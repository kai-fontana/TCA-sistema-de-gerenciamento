# Prisma Project 2.0: Student Management System

Prisma 2.0 is a **Final Learning Project** that consists of developing a student registration and management system. The initiative arose from the need of the _Centro Social Marista (CESMAR)_ Learning Center to replace the old system (_Prisma_), which will be discontinued. The project aims to provide a concise, well-structured, and executable platform for the administrative area.

# 🚀 Structure and Functionalities

The project was structured with 4 main web pages to meet the demands of the _Centro Social Marista (CESMAR)_.

### 1. Login

This page is the access point for administrative collaborators, allowing them to add, modify, and remove data.

- Authentication via email and password.

- Option to perform a new registration.

- Option for password recovery or change.

### 2. Home Page

After logging in, the user is directed to the system's home screen.

- Display of the administrator's name.

- List of the Center's classes (turmas).

- Search bar, notifications, and messages icons resources.

- Drop-down menu with options to edit profile, switch, and log out of the account.

### 3. Class Registration

An essential feature that allows the user to register new classes.

- Registration of classes and their respective students (educandos).

- Insertion of students' personal data.

### 4. Classes (Detailed View)

Upon accessing a specific class, this page displays all relevant information and management tools.

- List of students with full name, email, and photo.

- Attendance control with mentions for Present (P), Absent (A), and Justified Absence (JA).

- Display of the class's average attendance.

- Monitoring of the Center's calendar and events.

- Options to add, edit, and delete students in the list.

# 💻 Technical View

The project was initialized from Spring Initializr and follows the **MVC (Model-View-Controller)** architecture pattern to organize the code into different layers and separate the Front-End from the Back-End.

|     Category     |      Technology/Pattern      |                       Details                      |
| :--------------: | :--------------------------: | :------------------------------------------------: |
| Front-End        | Thymeleaf                    | Thymeleaf links the HTML directly to the Back-End. |
| Library          | Bootstrap                    | Used to add templates.                             |
| Back-End         | Java                         | Main application language.                         |
| Framework        | Spring Boot                  | Version 3.5.7.                                     |
| Manager          | Maven                        | Dependency manager.                                |
| Architecture     | MVC (Model-View-Controller)  | Logical separation between Back-End and Front-End. |
| Database         | PostgreSQL                   | Linked to the application via Postgre Driver.      |
| IDE              | VS Code, IntelliJ            | Used for development.                              |

### Main Dependencies

The project uses the following dependencies:

- `Spring Web`

- `DevTools`

- `ThymeLeaf`

- `Lombok`

- `PostgreSQL (Postgre Driver)`

# 👥 Participants (TCA Team)

The project was developed as a team by:

- Gabriel Tavares
- Kaillanny Fontana dos Santos
- Luis Castro
- Marcos Yuri Rosa de Oliveira

[Link do Canva](https://www.canva.com/design/DAG45SW1Ark/4-ApmXU5rnh2xsZDSLA0vA/view?utm_content=DAG45SW1Ark&utm_campaign=designshare&utm_medium=link2&utm_source=uniquelinks&utlId=h5c2f742250)

