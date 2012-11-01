import scala.xml._

name := "scala-inflector"

version := "1.3.5"

organization := "io.backchat.inflector"

scalaVersion := "2.9.2"

crossVersion := CrossVersion.full

scalacOptions ++= Seq("-optimize", "-unchecked", "-deprecation", "-Xcheckinit", "-encoding", "utf8")

libraryDependencies <+= (scalaVersion) {
  case "2.10.0-RC1" => "org.specs2" % "specs2_2.10.0-RC1" % "1.12.2" % "test"
  case "2.9.2" | "2.9.1" | "2.9.1-1" => "org.specs2" %% "specs2" % "1.12.2" % "test"
  case "2.9.0-1" => "org.specs2" %% "specs2" % "1.8.2" % "test"
  case "2.9.0" => "org.specs2" %% "specs2" % "1.7.1" % "test"
  case _ => "org.specs2" %% "specs2" % "1.5" % "test"
}

libraryDependencies ++= Seq(
  // compilerPlugin("org.scala-tools.sxr" % "sxr_2.9.0" % "0.2.7"),
  "junit" % "junit" % "4.10" % "test"
)

autoCompilerPlugins := true

crossScalaVersions := Seq("2.8.0", "2.8.1", "2.8.2", "2.9.0", "2.9.0-1", "2.9.1", "2.9.1-1", "2.9.2", "2.10.0-RC1")

parallelExecution in Test := false

homepage := Some(url("https://github.com/backchatio/scala-inflector"))

startYear := Some(2010)

licenses := Seq(("MIT", url("http://github.com/backchatio/scala-inflector/raw/HEAD/LICENSE")))

pomExtra <<= (pomExtra, name, description) {(pom, name, desc) => pom ++ Group(
  <scm>
    <connection>scm:git:git://github.com/backchatio/scala-inflector.git</connection>
    <developerConnection>scm:git:git@github.com:backchatio/scala-inflector.git</developerConnection>
    <url>https://github.com/backchatio/scala-inflector</url>
  </scm>
  <developers>
    <developer>
      <id>casualjim</id>
      <name>Ivan Porto Carrero</name>
      <url>http://flanders.co.nz/</url>
    </developer>
  </developers>
)}

packageOptions <+= (name, version, organization) map {
    (title, version, vendor) =>
      Package.ManifestAttributes(
        "Created-By" -> "Simple Build Tool",
        "Built-By" -> System.getProperty("user.name"),
        "Build-Jdk" -> System.getProperty("java.version"),
        "Specification-Title" -> title,
        "Specification-Version" -> version,
        "Specification-Vendor" -> vendor,
        "Implementation-Title" -> title,
        "Implementation-Version" -> version,
        "Implementation-Vendor-Id" -> vendor,
        "Implementation-Vendor" -> vendor
      )
  }

publishMavenStyle := true

publishTo <<= version { (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

pomIncludeRepository := { x => false }

resolvers += "Sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

testOptions := Seq(
        Tests.Argument("console", "junitxml"))
        
testOptions <+= crossTarget map { ct =>
  Tests.Setup { () => System.setProperty("specs2.junit.outDir", new File(ct, "specs-reports").getAbsolutePath) }
}

exportJars := true
