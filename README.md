
# Hospital Management System

A console-based Hospital Management System developed using Java. This application manages patient records, doctor details, appointments, and billing through a menu-driven interface.

## Features

- Add and view patient records
- Add and view doctor details
- Search patients and doctors by ID
- Update patient information
- Delete patient records with appointment validation
- Book and view appointments
- Generate patient bills
- Input validation and exception handling
- Duplicate ID checking

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Java Collections Framework (ArrayList)
- Exception Handling
- Eclipse IDE

## Project Structure

```text
Hospital-Management-System/
├── src/
│   ├── module-info.java
│   └── hospital/
│       ├── Appointment.java
│       ├── Billing.java
│       ├── Doctor.java
│       ├── HospitalService.java
│       ├── Main.java
│       ├── Patient.java
│       └── Person.java
├── .classpath
├── .project
├── .settings/
└── README.md
```

## How to Run

1. Open Eclipse IDE.
2. Import the project using Existing Projects into Workspace.
3. Open `src/hospital/Main.java`.
4. Run it as a Java Application.

## Data Storage

Patient, doctor, and appointment records are stored in ArrayLists during program execution. Data is not permanently saved after the application closes.

## Author

Rasika Vasule
