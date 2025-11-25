# 📝 Task Tracker (Java + JDBC + MySQL)

A simple console-based CRUD application for managing tasks using Java, JDBC, and MySQL.

<p align="center">
  <img src="Screenshot%202025-11-25%20075221.png" width="600"/>
</p>

---

## 🏷️ Badges
![Java](https://img.shields.io/badge/Java-17-blue)
![MySQL](https://img.shields.io/badge/MySQL-Database-orange)
![JDBC](https://img.shields.io/badge/JDBC-Connector-yellow)
![Status](https://img.shields.io/badge/Status-Active-brightgreen)

---

## 🚀 Features
- Add new tasks  
- View all tasks  
- Update existing tasks  
- Delete tasks  
- Stores data in MySQL database  
- Uses JDBC + PreparedStatement for secure queries  

---

## 🛠️ Tech Stack
- Java 17+  
- MySQL 8+  
- JDBC  
- SQL  

---

## 📂 Project Structure
```
task-tracker/
│
├── src/
│   └── Main.java
│
├── sql/
│   └── tasks.sql
│
└── Screenshot 2025-11-25 075221.png
```

---

## ⚙️ Database Setup
```sql
CREATE DATABASE taskdb;
USE taskdb;

CREATE TABLE tasks (
  id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255),
  description VARCHAR(255)
);
```

---

## ▶️ How to Run

### Compile:
```bash
javac src/Main.java
```

### Run:
```bash
java Main
```

### MySQL Credentials (used in code):
```
URL      = jdbc:mysql://localhost:3306/taskdb
USER     = root
PASSWORD = root
```

---

## 📸 Sample Output
<p align="center">
  <img src="Screenshot%202025-11-25%20075221.png" width="600"/>
</p>

---

## ⭐ Future Improvements
- Add login system  
- Add GUI (JavaFX or Swing)  
- Add due dates & task status  
- Add pagination  

---

## 🤝 Contributing
Feel free to fork this project and improve it!
