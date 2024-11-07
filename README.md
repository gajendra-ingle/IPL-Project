# IPL Player Management System

The **IPL Player Management System** is a Java-based application designed to manage player data for IPL teams. This project emphasizes understanding the **Collection Framework**, **layered architecture**, and **Java-MySQL integration**.

## Project Structure

The application follows a layered architecture, ensuring modularity and maintainability. It is divided into the following packages:

1. **entity**: Contains classes that represent the core data models, such as Player, Team, etc.
2. **service**: Implements the business logic of the application.
3. **dao**: Handles database operations and interactions with MySQL.
4. **controller**: Manages the flow of data between the user and the system.
5. **utility**: Includes utility classes for tasks such as database connection, input validation, etc.


## Features

- **Player Management**: Add, update, delete, and search players.
- **Team Management**: Manage teams and assign players to teams.
- **Data Persistence**: Store and retrieve data using MySQL.
- **Layered Architecture**: Clean separation of concerns using DAO, service, and controller layers.
- **Efficient Data Handling**: Utilizes Java Collection Framework for in-memory operations.


## Technologies Used

- **Programming Language**: Java
- **Database**: MySQL
- **Frameworks**: Java Collection Framework
- **IDE**: Eclipse 


## Folder Structure

The project is organized into the following packages and classes:

```plaintext
src/
├── entity/
│   ├── Player.java         # Represents the Player entity
│   └── ...                 # Placeholder for additional entities
├── service/
│   ├── PlayerService.java  # Contains business logic for Player operations
│   └── ...                 # Placeholder for future service classes
├── dao/
│   ├── PlayerDAO.java      # Handles Player-related database operations
│   └── ...                 # Placeholder for additional DAO classes
├── controller/
│   ├── PlayerController.java  # Manages user requests and system flow for Players
│   └── ...                    # Placeholder for other controllers
├── utility/
│   ├── DatabaseConnection.java # Provides MySQL database connection utilities
│   └── ...                     # Placeholder for utility functions
└── Main.java                 # Entry point of the application

```

## Key Learning Outcomes
- Mastered the Java Collection Framework for data handling.
- Understood and implemented a layered architecture.
- Gained practical experience with Java-MySQL integration.


## Future Enhancements
- Expand the system to include team management.
- Add more entities and related CRUD functionalities.
- Develop a graphical user interface (GUI) for better usability.


