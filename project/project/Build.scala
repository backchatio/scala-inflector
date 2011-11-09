import sbt._
object PluginDef extends Build {
    override lazy val projects = Seq(root)
    lazy val root = Project("plugins", file(".")) dependsOn( webPlugin )
    lazy val webPlugin = uri("git://github.com/typesafehub/sbt-scalariform")
}

// vim: set ts=2 sw=2 et:
