# Simple Tic-Tac-Toe Game with Java Swing, Login, and Statistics

## Student Information
Name: Nalanda Mahabarata 

Student ID: 5026251004 

Class: Q

## Project Description
This project is a simple Tic-Tac-Toe game built using Java Swing. The application includes login, game statistics, and Top 5 scorer feature.

## Features
- Login using database
- Play Tic-Tac-Toe using Swing GUI
- Record wins, losses, draws, and score
- Display personal statistics
- Display Top 5 scorers using JTable
  
## Database
Database used: (Microsoft) SQL Server / mssql

Database Name:

```
game_project
```

Table:

```
players
```

Table Structure

| Column | Data Type | Description |
|---------|-----------|-------------|
| id | INT | Primary Key |
| username | VARCHAR(50) | Player username |
| password | VARCHAR(100) | Player password |
| wins | INT | Number of wins |
| losses | INT | Number of losses |
| draws | INT | Number of draws |
| score | INT | Total score |

Scoring System

| Result | Score |
|---------|------:|
| Win | +10 |
| Draw | +3 |
| Lose | +0 |

---

## How to Run

### 1. Start SQL Server

Run Microsoft SQL Server using Docker.

Example:

```bash
docker run \
-e "ACCEPT_EULA=Y" \
-e "MSSQL_SA_PASSWORD=YourPassword123!" \
-p 1435:1433 \
--name sql_server_container \
-d mcr.microsoft.com/mssql/server:2022-latest
```

### 2. Create Database

Create a new database named:

```
game_project
```

### 3. Add JDBC Driver

Download Microsoft JDBC Driver for SQL Server.

Place the driver inside:

```
lib/
└── mssql-jdbc-13.x.x.jre17.jar
```

### 4. Configure DatabaseManager.java

Update the database configuration.

```java
private static final String URL =
"jdbc:sqlserver://localhost:1435;"
+ "databaseName=game_project;"
+ "encrypt=true;"
+ "trustServerCertificate=true;";

private static final String USER = "sa";
private static final String PASSWORD = "YOUR_PASSWORD";
```

### 5. Run the Project

Run:

```
Main.java
```

---
   
## Class Explanation
### Main

The entry point of the application. It launches the Login window.

### DatabaseManager

Responsible for creating the connection between the Java application and the SQL Server database using JDBC.

- Store database configuration
- Create database connection
- Return Connection object

### Player

Represents a player object.

Attributes:

- id
- username
- wins
- losses
- draws
- score

### PlayerService

Handles all database operations related to players.

- Login validation
- Update player statistics
- Retrieve Top 5 scorers

### GameLogic

Contains all game rules.

- Initialize the board
- Validate moves
- Detect winners
- Detect draw
- Generate computer moves
- Reset board

### LoginFrame

The first window shown to the user.

- Input username
- Input password
- Authenticate user
- Open Main Menu after successful login

### MainMenuFrame

Displays the main navigation.

- Start Game
- View Statistics
- View Top 5 Scorers
- Exit Application

### GameFrame

Displays the Tic-Tac-Toe game board.

- Handle player moves
- Handle computer moves
- Determine game result
- Update statistics after game completion

### StatisticsFrame

Displays the logged-in player's statistics.

- Username
- Wins
- Losses
- Draws
- Total Score

### TopScorersFrame

Displays the Top 5 highest-scoring players using JTable.

- Username
- Wins
- Losses
- Draws
- Score

---
## Screenshots
Login Window:

<img width="436" height="311" alt="login-window" src="https://github.com/user-attachments/assets/24f9784a-6331-4003-bf56-d0402456dc39" />

Game Window:

<img width="417" height="418" alt="game-window" src="https://github.com/user-attachments/assets/3f909b67-6dbe-4942-81b5-880c6f5a1a22" />

Top Scorers Window:

<img width="424" height="215" alt="top-scorers-window" src="https://github.com/user-attachments/assets/e5cafeb1-8fb6-4447-8b20-abb4d91e1b2a" />


## Video Link
YouTube:
