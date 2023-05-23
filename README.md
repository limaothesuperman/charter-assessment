# Rewards Calculation System Design Document


The Rewards Calculation System is a web application that calculates reward points for customers based on their transaction history. The system allows customers to view their monthly reward points and the total reward points earned over a given period.

## Design Document

The design document can be found here:
https://github.com/limaothesuperman/charter-assessment/blob/main/Rewards%20Calculation%20System%20Design%20Document.pdf

## Prerequisites

Before running the application, ensure that you have the following prerequisites installed:

- Java Development Kit (JDK) 17 or higher
- Maven
- MySQL Database

## Getting Started

Follow these steps to get the Rewards Calculation System up and running:

1. Clone the repository:

   ```shell
   git clone https://github.com/limaothesuperman/charter-assessment.git
2. Open the project in your preferred IDE.

3. Configure the database connection:

   - Open the application.properties file located in the src/main/resources directory.
   - Update the database connection properties (url, username, password) with your MySQL database details.
   - :bangbang:Notice: The data.sql file under resources file will seed the database with some testing data at the first time application starting.:bangbang:
   - :bangbang:If you start the application one more time, please change the property in application.properties file. As state below:bangbang:
   - First start use this command below to seed the database for testing
   - ```shell 
     spring.sql.init.mode=always
   - After first start, can change to this command below for continually running
   - ```shell 
     spring.sql.init.mode=embedded
     
4. Build the application:
   ```shell
   mvn clean install
5. Run the application:
   ```shell
   mvn srping-boot:run
6. The Rewards Calculation System will be accessible at http://localhost:8080.

## API Documentation
The API documentation for the Rewards Calculation System can be found here.

Please refer to the API documentation for detailed information on the available endpoints and their usage.

## Testing
The Rewards Calculation System includes unit tests to ensure the correctness of the business logic and functionality. You can run the tests using the following command:
   ```shell
   mvn test
   ```
And a sample testing screenshot can be found here: