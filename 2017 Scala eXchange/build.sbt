
// The simplest possible sbt build file is just one line:

scalaVersion := "2.12.3"

name := "2017_12_conference_scala_exchange"
organization := "com.lukastymo"
version := "1.0"

addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.4")

val freestyleV = "0.4.4"
val catsEffectV = "0.4"
val akkaV = "2.5.7"
val configV = "1.3.2"
val scalatestV = "3.0.1"

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats" % "0.9.0",
  "eu.timepit" %% "refined" % "0.8.4",
  "io.frees" %% "frees-core" % freestyleV,
  "io.frees" %% "frees-tagless" % freestyleV,
  "org.typelevel" %% "cats-effect" % catsEffectV,

)

scalacOptions ++= List("-unchecked",
  "-Ywarn-unused-import",
  "-Xfatal-warnings",
  "-Ypartial-unification",
  "-language:higherKinds",
  "-Xlint")

fork := true
