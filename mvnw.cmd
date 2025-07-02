@echo off
rem Maven wrapper script for Windows

setlocal

set MAVEN_WRAPPER_JAR=.mvn\wrapper\maven-wrapper.jar
set MAVEN_WRAPPER_PROPERTIES=.mvn\wrapper\maven-wrapper.properties

if not exist "%MAVEN_WRAPPER_JAR%" (
    echo The Maven wrapper jar file does not exist. Please run "mvn -N io.takari:maven:wrapper" to generate it.
    exit /b 1
)

java -cp "%MAVEN_WRAPPER_JAR%" org.apache.maven.wrapper.MavenWrapperMain %*