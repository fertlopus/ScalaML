name := "MachineLearningAlgorithms"
version := "0.1"
scalaVersion := "2.13.12"

lazy val root = (project in file("."))
  .settings(
    name := "ScalaMLpack"
  )

// Add any necessary dependencies here
libraryDependencies ++= Seq(
  "com.github.tototoshi" %% "scala-csv" % "1.3.10"
)
