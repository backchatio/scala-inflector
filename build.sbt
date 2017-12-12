import scala.xml._

name := "scala-inflector"

version := "1.3.6"

organization := "io.backchat.inflector"

scalaVersion := "2.12.4"
crossScalaVersions := Seq("2.11.11", "2.12.4")

crossVersion := CrossVersion.binary

scalacOptions ++= Seq("-feature", "-unchecked", "-deprecation", "-Xcheckinit", "-encoding", "utf8")

scalacOptions := scalacOptions.value :+ Option(scalaVersion.value).filter(_.startsWith("2.12"))
  .map(v => "-opt:l:method")
  .getOrElse("-optimize")

libraryDependencies <+= (scalaVersion) {
  case v if v.startsWith("2.12") => "org.specs2" %% "specs2-core" % "3.9.5" % "test"
  case _ => "org.specs2" %% "specs2" % "2.3.11" % "test"
}

libraryDependencies ++= Seq(
  // compilerPlugin("org.scala-tools.sxr" % "sxr_2.9.0" % "0.2.7"),
  "junit" % "junit" % "4.10" % "test"
)

autoCompilerPlugins := true

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

exportJars := true
