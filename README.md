# WEB_HAPPY Project

## Overview
This project is a web application built using Spring Boot. It aims to provide a user-friendly interface and robust backend services.

## Project Structure
The project follows a standard Maven directory structure:

```
WEB_HAPPY
├── .mvn
│   └── wrapper
│       ├── maven-wrapper.jar
│       └── maven-wrapper.properties
├── .settings
│   ├── org.eclipse.core.resources.prefs
│   ├── org.eclipse.jdt.apt.core.prefs
│   ├── org.eclipse.jdt.core.prefs
│   └── org.eclipse.m2e.core.prefs
├── src
│   ├── main
│   │   ├── java
│   │   └── resources
│   └── test
│       ├── java
│       └── resources
├── .classpath
├── .factorypath
├── .gitignore
├── .project
├── HELP.md
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven (optional, as the project uses Maven Wrapper)

### Running the Application
To run the application, use the following command:

```
./mvnw spring-boot:run
```

For Windows, use:

```
mvnw.cmd spring-boot:run
```

### Building the Application
To build the application, run:

```
./mvnw clean package
```

### Testing
To run the tests, execute:

```
./mvnw test
```

## Contributing
Contributions are welcome! Please open an issue or submit a pull request for any improvements or bug fixes.

## License
This project is licensed under the MIT License. See the LICENSE file for details.