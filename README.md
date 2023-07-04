# Order Management Application

This is a Spring Boot application for managing orders.

## Building the Application

To build the application, follow these steps:

1. Make sure you have Java JDK 11 or later installed.
2. Clone this repository to your local machine.
3. Navigate to the root directory of the project.
4. Open a terminal or command prompt.
5. Run the following command to build the application:

./mvnw clean install 
or 
mvn clean install


This command will compile the source code, run tests, and package the application into a JAR file.

## Creating and Running the Docker Image

To create and run the Docker image of the application, follow these steps:

1. Make sure you have Docker installed on your machine. If not, download and install Docker from the official website: https://www.docker.com/get-started.
2. Clone this repository to your local machine if you haven't already.
3. Navigate to the root directory of the project.
4. Open a terminal or command prompt.
5. Build the Docker image by running the following command:

docker build -t order-management-app .


This command will create a Docker image with the tag `order-management-app`.

6. Run the Docker container by executing the following command:

docker run -p 8080:8080 order-management-app


This will start the container and map port 8080 of the container to port 8080 of your local machine.

7. You can now access the application by opening your web browser and navigating to http://localhost:8080.

