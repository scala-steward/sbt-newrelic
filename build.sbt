organization := "com.gilt.sbt"

name := "sbt-newrelic"

scalaVersion := "2.12.10"

crossScalaVersions := Seq(scalaVersion.value, "2.13.1")

crossSbtVersions := List("0.13.18", "1.3.5")

enablePlugins(SbtPlugin, GitVersioning, GitBranchPrompt)

scriptedLaunchOpts := { scriptedLaunchOpts.value ++
  Seq("-Xmx1024M", "-XX:MaxPermSize=256M", "-Dplugin.version=" + version.value)
}

scriptedBufferLog := false

git.useGitDescribe := true

scalacOptions ++= List(
  "-unchecked",
  "-deprecation",
  "-Xlint",
  "-encoding", "UTF-8"
)

addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.5.2" % "provided")

publishMavenStyle := false

bintrayOrganization := Some("giltgroupe")

bintrayPackageLabels := Seq("sbt", "newrelic", "sbt-native-packager")

bintrayRepository := "sbt-plugin-releases"

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
