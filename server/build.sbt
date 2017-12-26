name := "akka-stream-game-server-server"

version := "1.0"

scalaVersion := "2.12.3"

libraryDependencies ++= Seq(
  "com.typesafe.akka" % "akka-stream_2.12" % "2.5.8",
  "com.typesafe.akka" % "akka-stream-testkit_2.12" % "2.5.8",
  "com.typesafe.akka" % "akka-http-core_2.12" % "10.1.0-RC1",
  "com.typesafe.akka" % "akka-http-testkit_2.12" % "10.1.0-RC1",
  "com.typesafe.akka" % "akka-http-spray-json-experimental_2.12.0-RC2" % "2.4.11",
  "org.scalatest" %% "scalatest" % "3.0.0" % "test"
)

