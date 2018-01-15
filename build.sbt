organization := "ca.prosperpod"
name := "prosper-core"

version := "2.0.1"
scalaVersion := "2.12.4"

// Artima Maven Repo for SuperSafe Plugin
resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"


// << Dependencies >>

// ScalaTest
libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.4"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.4" % "test"


// Disable log buffering in favor one ScalaTest's built-in event buffering
logBuffered in Test := false
