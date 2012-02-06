
name := "scala-inflector"

version := "1.3.1-SNAPSHOT"

organization := "com.mojolly.inflector"

scalaVersion := "2.9.1"

scalacOptions ++= Seq("-optimize", "-unchecked", "-deprecation", "-Xcheckinit", "-encoding", "utf8")

libraryDependencies <+= (scalaVersion) {
  case "2.9.0-1" => "org.specs2" %% "specs2" % "1.5" % "test"
  case _ => "org.specs2" %% "specs2" % "1.6.1" % "test"
}

libraryDependencies ++= Seq(
  compilerPlugin("org.scala-tools.sxr" % "sxr_2.9.0" % "0.2.7"),
  "junit" % "junit" % "4.10"
)

resolvers += "ScalaTools Snapshots" at "http://scala-tools.org/repo-snapshots"

autoCompilerPlugins := true

crossScalaVersions := Seq("2.9.1", "2.9.0-1")

parallelExecution in Test := false

testFrameworks += new TestFramework("org.specs2.runner.SpecsFramework")

publishTo <<= (version) { version: String =>
  val nexus = "http://nexus.scala-tools.org/content/repositories/"
  if (version.trim.endsWith("SNAPSHOT")) Some("snapshots" at nexus+"snapshots/") 
  else                                   Some("releases" at nexus+"releases/")
}

testOptions := Seq(
        Tests.Argument("console", "junitxml"))
        
testOptions <+= crossTarget map { ct =>
  Tests.Setup { () => System.setProperty("specs2.junit.outDir", new File(ct, "specs-reports").getAbsolutePath) }
}

exportJars := true
