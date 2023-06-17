CREATE TABLE students (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    student_name VARCHAR(200) NOT NULL,
    student_number VARCHAR(200) NOT NULL UNIQUE
);

CREATE TABLE computers (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    computer_number VARCHAR(200) NOT NULL,
	computer_description VARCHAR(900) NOT NULL,
    time_of_use DATETIME NOT NULL,
    student_number VARCHAR(200) NOT NULL,
    FOREIGN KEY (student_number) REFERENCES students(student_number)
);

CREATE TABLE administrators (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    admin_name VARCHAR(250),
    username VARCHAR(250) NOT NULL,
    admin_password VARCHAR(250) NOT NULL
);