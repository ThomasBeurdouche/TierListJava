CREATE DATABASE IF NOT EXISTS local_database;
USE local_database;

CREATE TABLE IF NOT EXISTS example_table (
                                             id INT AUTO_INCREMENT PRIMARY KEY,
                                             name VARCHAR(255) NOT NULL
    );

INSERT INTO example_table (name) VALUES ('Sample Data');