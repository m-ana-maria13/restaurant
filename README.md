# Restaurant Management

## Description
A Java/Spring application for managing a restaurant:
menu items, staff members, tables, orders, customers and bills.


## Technologies
- Java 25
- Spring


## Project structure
- `model` – entities (Staff, Server, Chef, MenuItem, Bill, Customer, Order, Table, OrderLine, OrderAssignment)
- `repository` – in-memory storage 
- `service` – business logic and validation
- `controller` – user interface


## Architecture
The project uses a layered architecture. Each layer only depends on the one below it:
controller -> service -> repository -> model

- **model** has no dependencies on other layers.
  Chef and Server extend Staff, so a single repository handles all staff members.
  
- **repository** only stores data. A generic `IRepository<T>` interface and an abstract
  `InMemoryRepository<T>` base class avoid repeating the CRUD logic for each entity
  and follow the SOLID principles.
  
- **service** holds all validation and business rules, so they apply
  no matter how the data is accessed.
  
- **controller** talks only to services, never directly to repositories.

Storage is in memory behind the `IRepository` interface, so it can be
replaced with files or a database without changing the services.


## SOLID principles
- **Single Responsibility:** each layer has one job. Repositories only store data,
  services only validate and apply business rules, and controllers only handle
  interaction with the user. A change in one concern touches only one class.

- **Open/Closed:** `InMemoryRepository<T>` implements the CRUD logic once and is closed
  for modification. Supporting a new entity only requires extending it,
  without changing any existing code.

- **Dependency Inversion:** services depend on the `IRepository<T>` abstraction, not on
  a concrete implementation. The in-memory storage can be replaced with files or a
  database without modifying the services.


## How to run
1. Clone the repo
2. Open it in IntelliJ
3. Run the `RestaurantManagementAppApplication`


## Authors
- Sara Vlaicu
- Ana-Maria Malanca
