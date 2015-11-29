name := "spark_examples"

version := "1.0"

scalaVersion := "2.11.7"

val sparkVersion = "1.5.2"

libraryDependencies ++= Seq(
"org.apache.spark" %% "spark-core" % sparkVersion % "provided"
)

