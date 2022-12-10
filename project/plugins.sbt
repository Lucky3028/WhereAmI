// FatJarを生成するためのプラグイン
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "2.1.0")
// Lintをするためのプラグイン
addSbtPlugin("ch.epfl.scala" % "sbt-scalafix" % "0.10.4")
// Formatをするためのプラグイン
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.5.0")
// バージョン生成を自動で行うためのプラグイン
addSbtPlugin("com.dwijnand" % "sbt-dynver" % "4.1.1")
