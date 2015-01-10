name := "scalapresentation"

organization := "gamesys.presentation"

version := "1.0.0"

scalaVersion := "2.11.4"

scalacOptions ++= Seq("-unchecked", "-deprecation", "-encoding", "utf8")

javacOptions ++= Seq("-Xlint:deprecation", "-encoding", "utf8", "-XX:MaxPermSize=256M")

libraryDependencies += "com.google.guava" % "guava" % "18.0"