# Spelltome-Backend
This project is the back-end to Spelltome, a MUD-inspired rouguelike social media webapp powered by Spring Boot, React.js and lexical framework. Built for the C17 Ada Developer's Academy capstone. See frontend [`here`](https://github.com/wet-bulb/Spelltome-frontend).

## Dependencies
- JDK 18
- Maven
- PostegreSQL
- IntelliJ IDEA or your preferred IDE

## Setup
1. Clone application
2. Install JDK 18
3. Install Maven and configure `%JAVA_HOME%` environment variable
4. Create PostgreSQL database
5. Change datasource username and password in application.properties
6. Run with `mvn spring-boot:run`
7. Seed users with POST request to `/wizards/invites` with JSON request body (Change the names! These are your invite codes):
    
    `{"id": 0, "names": [{wizardname}, {adifferentwizardname}, {athirdname}]}`
