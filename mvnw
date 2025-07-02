#!/bin/sh

# Maven wrapper script for Unix-based systems

MAVEN_WRAPPER_JAR=".mvn/wrapper/maven-wrapper.jar"
MAVEN_PROPERTIES=".mvn/wrapper/maven-wrapper.properties"

if [ ! -f "$MAVEN_WRAPPER_JAR" ]; then
  echo "Error: Maven wrapper JAR not found at $MAVEN_WRAPPER_JAR"
  exit 1
fi

exec java -cp "$MAVEN_WRAPPER_JAR" org.apache.maven.wrapper.MavenWrapperMain "$@"