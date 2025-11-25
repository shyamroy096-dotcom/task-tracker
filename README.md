# Task Tracker (Java + JDBC + MySQL)

A simple console-based task management application built using Java, JDBC, and MySQL.  
You can add, update, delete, and view tasks from the database.

---

## 🚀 Features
- Add new tasks  
- Update existing tasks  
- Delete tasks  
- View all tasks  
- Stores data in MySQL  
- Uses clean OOP structure  

---

## 🛠 Tech Stack
- Java  
- JDBC  
- MySQL  
- OOP Principles  

---

## 🗂 Database Setup

Run this SQL in MySQL Workbench:

```sql
CREATE DATABASE taskdb;

USE taskdb;

CREATE TABLE tasks (
  id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255),
  description VARCHAR(255)
);
