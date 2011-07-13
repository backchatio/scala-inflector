import com.github.oforero.sbtformatter.SbtFormatter._
import com.github.oforero.sbtformatter.SbtFormatterSettings._

name := "logback-akka"

version := "1.1-SNAPSHOT"

organization := "com.mojolly.inflector"

scalaVersion := "2.9.0-1"

scalacOptions ++= Seq("-optimize", "-unchecked", "-deprecation", "-Xcheckinit", "-encoding", "utf8")

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "1.5" % "test"
)

libraryDependencies ++= Seq(
  compilerPlugin("org.scala-tools.sxr" % "sxr_2.9.0" % "0.2.7")
)

autoCompilerPlugins := true

parallelExecution in Test := false

testFrameworks += new TestFramework("org.specs2.runner.SpecsFramework")

credentials += Credentials(Path.userHome / ".ivy2" / ".scala_tools_credentials")

publishTo <<= (version) { version: String =>
  val nexus = "http://nexus.scala-tools.org/content/repositories/"
  if (version.trim.endsWith("SNAPSHOT")) Some("snapshots" at nexus+"snapshots/") 
  else                                   Some("releases" at nexus+"releases/")
}

seq( formatterPreferences : _*) 

seq( 
  indentLocalDefs := false,
  spaceBeforeColon := false,
  spaceInsideBrackets := false,
  spaceInsideParentheses := false,
  preserveDanglingCloseParenthesis := false,
  compactStringConcatenation := false
) 

seq( formatterTasks : _* )
