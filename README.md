# Project Prisma 2.0: Student Management System

## 📄 Introduction

* **Brief Project Description:** Prisma 2.0 is a **Learning Completion Project (TCA - *Trabalho de Conclusão de Aprendizagem*)** that consists of developing a student registration and management system. It was designed to replace the old system (*Prisma*) at the Learning Center of **Centro Social Marista (CESMAR)**, which is scheduled for discontinuation.
* **Objective:** The main objective of the project is to provide a concise, well-structured, and executable platform for the administrative area of CESMAR, optimizing the process of registration, attendance tracking, and management of classes and students.
* **Problem Statement:** The need arose from the imminent discontinuation of the legacy system (*Prisma*), demanding the development of a new, robust, and modern solution to ensure continuity and efficiency in managing the learning center's student data.
* **Target Audience:** Administrative staff at Centro Social Marista (CESMAR), including managers, coordinators, and personnel responsible for student registration and monitoring.

---

## 💻 Technologies Used

The project was initialized using Spring Initializr and follows the **MVC (Model-View-Controller)** architectural pattern to organize the code into different layers and separate the Front-End from the Back-End.

| Category | Technology/Pattern | Details |
| :---: | :---: | :---: |
| Front-End | **Thymeleaf** | Thymeleaf directly links HTML to the Back-End. |
| Library | **Bootstrap** | Used for adding templates and responsive design. |
| Back-End | **Java** | Primary application language. |
| Framework | **Spring Boot** | Version 3.5.7. |
| Dependency Manager | **Maven** | Dependency management tool. |
| Architecture | **MVC (Model-View-Controller)** | Logical separation between Back-End and Front-End. |
| Database | **PostgreSQL** | Linked to the application via Postgre Driver. |
| IDE | **VS Code, IntelliJ** | Used for development. |

### Key Dependencies
The project utilizes the following dependencies:
* `Spring Web`
* `DevTools`
* `ThymeLeaf`
* `Lombok`
* `PostgreSQL (Postgre Driver)`

---

## ⚙️ Development Process

The development of Prisma 2.0 followed a well-defined cycle, progressing through the following stages:

<img width="1042" height="316" alt="image" src="https://github.com/user-attachments/assets/4f60330b-7b71-49be-860f-6291267ba489" />


### 1. Planning
In this phase, we analyzed the functionalities of the legacy system and gathered all **requirements** together with CESMAR. We defined the **MVC architecture** and chose the technologies (Java, Spring Boot, PostgreSQL) based on robustness and scalability. The project scope was detailed, resulting in the 4 main pages and their functionalities.

### 2. Prototyping
We created a prototype.

<img width="790" height="450" alt="print-prototipo" src="https://github.com/user-attachments/assets/41b8632a-1466-4723-b21f-d0b31ca2c144" />

### 3. Coding
* **Back-End:** Implementation of business logic, REST APIs, *Controllers* (responsible for communication), and *Models* (entities and data rules) using **Java** and **Spring Boot**.
* **Front-End:** Development of user interfaces (*Views*) using **HTML** and **Thymeleaf** for dynamic integration with the Back-End, and **Bootstrap** for *layout* and responsive *design*.
* **Database:** Creation of the database schema in **PostgreSQL** and configuration of the connection via *Postgre Driver*.

### 4. Testing and Validation
To ensure the stability of the system prior to deployment, we implemented a rigorous verification strategy. We utilized **Loggers** extensively to monitor the internal behavior of the application, critically focusing on the **Student** and **Attendance** modules. This practice allowed us to track the data flow and validate the business logic "behind the scenes." Parallel to this technical monitoring, we performed comprehensive manual tests on **all functionalities** of the system, ensuring the integrity of the application before final deployment.

### 5. Deploy
We tested and observed the functionality of all our application's features, simply by running it and fixing all the errors.

---

## ⚠️ Difficulties and Solutions

The development of any system presents challenges. The main obstacles and the solutions implemented were:

* **Difficulty:** **Complex Object-Relational Mapping (ORM):** Dealing with the relationships between entities (Students, Classes, Attendance, Frequency) in PostgreSQL via JPA/Hibernate.
* **Solution:** Clear definition of primary and foreign keys and the correct use of `@OneToMany`, `@ManyToOne`, and `@ManyToMany` annotations in Java, ensuring data integrity and query performance.

---

## 📈 Final Result and Learnings

### Final Result
After all the development stages of this project, the final structure is as follows:

### 1. Login
* Authentication via email and password.
* Option to create a new registration.
* Option for password recovery or change.

### 2. Home Page
* Display of the administrator's name.
* List of the Polo's classes.
* Search bar, notification icon, and messaging features.
* Drop-down menu with options to edit profile, switch, and log out of the account.
* Student registration.
* Class attendance list.

### 3. Class Registration
* Class registration (addition, removal, and editing).
* Visualization of class information.

### 4. Classes (Detailed View)
* List of students with full name, email, and photo.
* Display of the class's average attendance.

### 5. Attendance
* Attendance control with mentions for **Present (P)**, **Absent (A)**, and **Justified Absence (JA)**.
* Options to add, edit, and delete students from the list.
* Monitoring of the Polo's calendar and events.

### Learnings
The project development provided valuable lessons in several areas:
* **Software Architecture:** Practical understanding of the **MVC** pattern and its application in Spring Boot, separating the concerns of the Front-End and Back-End.
* **Full Stack Development:** Complete experience in the interconnection between **Java** (business logic) and **Thymeleaf/Bootstrap** (user interface).
* **Database Management:** Consolidation of knowledge in **PostgreSQL** and **JPA/Hibernate** mapping, crucial for data persistence and integrity.
* **Teamwork:** Improvement of collaboration skills, task division, and joint problem-solving in a large-scale project.

---

## 🤝 Conclusion

The development of **Prisma 2.0** was, without a doubt, our biggest project. We faced a complex technical challenge, but the true differentiator for success was our ability to work together. Thanks to the team's unity, good communication, and balanced task division, we managed to overcome unforeseen difficulties and lead the project masterfully.

This journey brought us valuable professional experience and learnings that go far beyond coding. We delivered a well-structured and polished solution, with the satisfaction of having grown professionally and proven the strength of our collaboration.

---

## 💡 Possible Future Improvements

For future versions, we suggest the following expansions and optimizations:
* **Automatic Notifications:** Add a system for sending emails or SMS notifications to guardians in cases of unjustified absences;
* **Multi-user:** Administrator and Educator;
* **User registration:** Adding a sing up page;
* **Class/Group:** Editing the class;
* **Roll call:** Reports of students and attendance.

---

## 👥 Participants (TCA Team)

The project was developed by the team:
* Gabriel Tavares
* Kaillanny Fontana dos Santos
* Luis Castro
* Marcos Yuri Rosa de Oliveira





