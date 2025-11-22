Student Record System (Java Serialization)

A layered Java application that manages student records with persistent storage using object serialization.
The project demonstrates object-oriented design, separation of concerns, custom exceptions, data validation, and file-based persistence.

Features
Create, update, delete, and view student records.
Persistent storage via Java serialization (ObjectOutputStream / ObjectInputStream).
Automatic loading of records on application startup.
Validation of student data before insertion or updates.
Custom exception handling for invalid input or inconsistent state.
Cleanly separated architecture with model, service, and persistence layers.

Technologies
Java 17+
Java Serialization
JUnit (For testing)

Architecture Overview
The project is divided into clear layers to maintain modularity and readability.
1. Model Layer
Contains domain objects.
Student
Represents a student record with fields such as ID, name, and age.
Implements Serializable.

2. Persistence Layer
Handles storage and retrieval of records from disk.
StudentDatabase
Responsible for serializing and deserializing the list of students.
Knows the file path (students.dat) and manages streams.

3. Service Layer
Contains business logic.
StudentService
Provides operations such as add, update, delete, search, list.
Validates data and throws exceptions.
Delegates all storage work to the persistence layer.

4. Exceptions
Domain-specific exceptions for predictable failure cases.
InvalidStudentException
Thrown when student data is missing, malformed, or violates rules
(e.g., duplicate IDs, negative age, empty names).

5. Application Layer
Main
Simple entry point that loads existing data, interacts with the service layer, and triggers save operations.
Can be a CLI interface or a placeholder for future GUI development.
Project Structure

StudentFileSystem/ 
│

├── README.md

└── src/

└── main/

└── java/

└── com.yourorg/students/

├── model/

│   └── Student.java 

│

├── exceptions/

│   └── InvalidStudentException.java

│

├── persistence/

│   └── StudentDatabase.java

│

├── service/

│   └── StudentService.java

│

└── app/

└── Main.java

Data Flow

Startup
StudentDatabase attempts to deserialize existing student data from students.dat.
If the file does not exist, it initializes an empty list.

Operations
StudentService receives requests (add, update, delete, find, list) from Main.
Input is validated.
Any invalid data triggers InvalidStudentException.

Persistence
After modifications, the updated list is serialized back to disk.

Serialization File
Default: students.dat
Stored in the project root unless changed in configuration.

How to Run
Compile using your IDE or command line.
Run Main.java.
Existing records load automatically.
New operations update the serialized data file.
Potential Improvements
Replace binary serialization with JSON (Gson/Jackson).
Add sorting and filtering features.
Implement interfaces for repository patterns.
Add unit tests for validation and service logic.
Build a GUI or REST API layer on top of the service layer.