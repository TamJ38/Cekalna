# Chekalna

## Table of Contents

- [Description](#description)
- [Tech Stack](#tech-stack)
- [Installation](#installation)
- [Key Features](#key-features)

## Description

**Chekalna** is a web-based application designed to manage professor consultations, student reservations, and room bookings. The application allows professors to create and manage consultations, set available slots, and allow students to reserve consultations. It offers features for managing queues, tracking waiting times, and ensuring students are not double-booked for consultations.

The system includes detailed features for professors, such as managing consultations (creating, updating, copying, and deleting), viewing and updating reservations, and managing consultation queues. For students, the system allows viewing available consultations, making reservations, and tracking their own reservation history. The application is designed to streamline the consultation scheduling process and reduce administrative overhead for both professors and students.

## Tech Stack

- **Frontend**: Thymeleaf, HTML, CSS, JavaScript
- **Backend**: Spring Boot (Java)
- **Database**: PostgreSQL 

## Installation

Follow these steps to set up the project locally:

### 1. Clone the repository

First, clone the repository to your local machine:

```bash
git clone https://github.com/swiftmg0d/Cekalna.git
```

### 2. Navigate to the project directory

Change into the project directory:

```bash
cd Cekalna
```

### 3. Set up PostgreSQL Database


1. **Clone the Repository:**

   Clone the `common-model` repository to your local machine:

   ```bash
   git clone https://gitlab.finki.ukim.mk/wp/common-model.git
   ```


2. **Navigate to the Project Directory:**

   Move into the cloned project directory:

   ```bash
   cd common-model
   ```



3. **Start the Services with Docker Compose:**

   Use Docker Compose to build and start the services defined in the `docker-compose.yml` file:

   ```bash
   docker-compose up
   ```


   This command will pull the necessary Docker images (if not already present), build the services, and start the containers. Your Spring Boot application will connect to the PostgreSQL database as defined in the `docker-compose.yml` file.


5. **Access the Application:**

   With the services running, you should be able to access your Spring Boot application, which will interact with the PostgreSQL database running in the Docker container.



### 4. Run the Backend Application

Make sure that you have Java 17 or higher installed on your machine. If not, install it from [here](https://openjdk.java.net/).

- Open the project in your favorite IDE (e.g., IntelliJ IDEA or Eclipse).
- Build and run the Spring Boot application.

You can also use the following command to run the backend:

```bash
./mvnw spring-boot:run
```

### 5. Testing the App

Once everything is set up, you should be able to:

- View available consultations for professors.
- Make reservations for consultations.
- Professors can create, update, copy, and delete consultations.
- Manage queues, update reservation statuses, and view statistics.

## Key Features:

- **Professor Consultation Management**: Create, update, copy, and delete consultation slots.
- **Student Reservation System**: Reserve consultation slots based on availability.
- **Queue Management**: Professors can manage consultation queues and track student progress.
- **Waiting Time Tracking**: Track average waiting times for consultations.
- **Authentication**: Secure login and registration for professors and students.
- **Database Integration**: All consultations, reservations, and professors are stored in a PostgreSQL database.
- **Error Handling**: Handle edge cases like double reservations or unavailable slots.
- **Searchable Consultations**: Professors and students can search consultations by various criteria.
- **User-Friendly Interface**: Simple and intuitive interface for managing consultations and reservations.

---


