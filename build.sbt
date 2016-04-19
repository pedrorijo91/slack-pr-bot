name := """slack-pr-bot"""

version := "1.0"

scalaVersion := "2.11.7"

// Change this to another test framework if you prefer
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"

libraryDependencies += "com.github.gilbertw1" %% "slack-scala-client" % "0.1.3"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.2"

libraryDependencies += "com.typesafe" % "config" % "1.3.0"

libraryDependencies += "com.typesafe.akka" % "akka-actor_2.11" % "2.4.1"

enablePlugins(JavaAppPackaging)
