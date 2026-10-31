# Patient Notification System

A university project developed in Java to demonstrate design patterns through a simple patient notification application.

## Features
- Create notifications with a description, value, and severity level.
- Route notifications according to three levels: Normal, Critical, and Very Urgent.
- Notify different recipients: nurses, doctors, ambulance services, and patient relatives.
- Display notifications in TEXT, XML, or JSON format.

## Technologies
- Java
- Java Swing
- Apache Ant
- NetBeans

## Design Patterns
- **Observer:** Notifies the registered recipients when a notification is sent.
- **Composite:** Organizes notification groups according to severity levels.
- **Adapter:** Selects the format used to display each notification.

## Run the Project
Open the project in NetBeans and run the main class `projet.Projet`.

Or build it from the project directory using:

```bash
ant jar
```

## Academic Project
This project was developed as part of university coursework to practice object-oriented programming and software design patterns. It is an educational prototype, not a real medical alert system.
