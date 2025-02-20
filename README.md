# Used Laptop Donation Application

A J2EE Web Application designed to supply used laptops to rural students by connecting donors, students, and an admin interface. This application allows donors to donate laptops, students to request laptops, and an admin to manage and approve these requests.

## Table of Contents

- [Overview](#overview)
- [Technologies](#technologies)
- [Features](#features)
- [Architecture](#architecture)
- [Process Flow Diagram](#process-flow-diagram)

## Overview

This application was built using Java EE (J2EE) and provides a user-friendly interface with three types of users:
- **Donors:** Can register, log in, donate laptops, view approved donation requests, and log out.
- **Students:** Can register, log in, request laptops, view the status of their requests, and log out.
- **Admin:** Can log in, view student laptop requests, approve requests, and log out.

## Technologies

This project leverages a range of technologies and tools:
- **Java EE (J2EE):** The core framework used for building enterprise-level web applications.
- **Servlets & JSP:** For handling server-side processing and rendering dynamic web pages.
- **Apache Tomcat:** As the application server for deploying the web application.
- **Relational Database (MySQL):** To store user, donation, and request data.
- **HTML/CSS/JavaScript:** For front-end development and enhancing user experience.

## Features

- **User Registration and Login:** Separate registration and login processes for donors, students, and admin.
- **Donor Dashboard:**
  - Add laptops for donation.
  - View student requests approved by the admin.
  - Logout.
- **Student Dashboard:**
  - Submit laptop requests.
  - View the status of their requests.
  - Logout.
- **Admin Dashboard:**
  - View all raised requests from students.
  - Approve student requests.
  - Logout.

## Architecture

This application follows the Model-View-Controller (MVC) architecture to separate concerns and improve maintainability:

- **Model:** Represents the application's data and business logic. It includes Java classes that interact with the database and perform data operations.
- **View:** Comprises the JSP pages and HTML/CSS used to render the user interface.
- **Controller:** Consists of Servlets and Java classes that handle user requests, process inputs, and coordinate responses by interacting with the Model and rendering the appropriate View.

This clear separation makes it easier to manage, test, and extend the application.

## Process Flow Diagram

```mermaid
graph TB
    A[Landing Page] --> B[Register/Login as Donor]
    A --> C[Register/Login as Student]
    A --> D[Login as Admin]

    B --> B1[Donor Dashboard]
    B1 --> B2[Add Laptop for Donation]
    B1 --> B3[View Approved Requests]
    B1 --> B4[Logout]

    C --> C1[Student Dashboard]
    C1 --> C2[Request Laptop]
    C1 --> C3[View Requests]
    C1 --> C4[Logout]

    D --> D1[Admin Dashboard]
    D1 --> D2[View Student Requests]
    D1 --> D3[Approve Requests]
    D1 --> D4[Logout]

    B2 --> B1
    B3 --> B1
    B4 --> A

    C2 --> C1
    C3 --> C1
    C4 --> A

    D2 --> D1
    D3 --> D1
    D4 --> A
