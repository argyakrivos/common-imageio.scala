lazy val root = (project in file(".")).
  settings(
    name := "common-imageio",
    organization := "com.blinkbox.books",
    version := scala.util.Try(scala.io.Source.fromFile("VERSION").mkString.trim).getOrElse("0.0.0"),
    scalaVersion := "2.11.4",
    scalacOptions := Seq("-unchecked", "-deprecation", "-feature", "-encoding", "utf8", "-target:jvm-1.7", "-Xfatal-warnings", "-Xfuture"),
    libraryDependencies ++= {
      Seq(
        "com.blinkbox.books"         %% "common-scala-test"  % "0.3.0"  % Test,
        "com.typesafe.scala-logging" %% "scala-logging"      % "3.1.0",
        "com.mortennobel"            %  "java-image-scaling" % "0.8.6",
        "com.jsuereth"               %% "scala-arm"          % "1.4",
        "commons-io"                 %  "commons-io"         % "2.4"    % Test,
        "org.apache.commons"         %  "commons-lang3"      % "3.3.2",
        "org.imgscalr"               %  "imgscalr-lib"       % "4.2"
      )
    }
  )
