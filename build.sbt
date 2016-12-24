name := "i18n-store"

version := "current"

scalaVersion := "2.11.7"

resolvers += Resolver.mavenLocal

libraryDependencies ++= Seq(
  "io.dropwizard" % "dropwizard-core" % "1.0.5",
  "org.glassfish.jersey.ext" % "jersey-entity-filtering" % "2.23.2",
  "org.glassfish.jersey.ext" % "jersey-declarative-linking" % "2.23.2",
  "org.glassfish.jersey.media" % "jersey-media-json-jackson" % "2.23.2" // runtime
)

mainClass in (Compile, run) := Some("i18nstore.I18nStoreApplication")
mainClass in assembly := Some("i18nstore.I18nStoreApplication")

// Needed for proper JUnit test output
testOptions += Tests.Argument(TestFrameworks.JUnit, "-v", "-q")

EclipseKeys.projectFlavor := EclipseProjectFlavor.Java

