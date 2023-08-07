# Spelltome: Origins
This is a full stack web app created for my Ada Developers Academy Cohort 17 capstone project. 

Spelltome is social media for wizards and other arcane magic users inspired by the early online roleplaying spaces known as MUDs and MUSHs. It takes an experimental approach to identity and persistence akin to roguelike/roguelite RPGs by allowing the souls of ancient wizards to take on a life of their own, evoked client-side by any player with their name. 

Spelltome uses an RTE based on Meta’s open source lexical framework to a handle a whole host of content-types to better support wizards in the casting and research of their often multi-faceted spells and rituals.

# Demo
![](https://github.com/wet-bulb/Spelltome-Backend/blob/main/spelltome_demo_gif.gif)

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
