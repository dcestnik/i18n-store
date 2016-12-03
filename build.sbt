name := "i18n-store"

version := "current"

scalaVersion := "2.11.7"

resolvers += Resolver.mavenLocal

libraryDependencies ++= Seq(
  "io.dropwizard" % "dropwizard-core" % "0.7.1",
  "org.apache.commons" % "commons-lang3" % "3.5"
)

mainClass in (Compile, run) := Some("i18nstore.I18nStoreApplication")
mainClass in assembly := Some("i18nstore.I18nStoreApplication")

// Needed for proper JUnit test output
testOptions += Tests.Argument(TestFrameworks.JUnit, "-v", "-q")

EclipseKeys.projectFlavor := EclipseProjectFlavor.Java

