CREATE DATABASE practise;
USE practise;

CREATE TABLE employee(
	id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    salary DECIMAL(10,2) CHECK(salary>0),
    department VARCHAR(50)
);

INSERT INTO employee(id, name, salary, department)
VALUES
(1, 'Sravan', 700000, 'BackEnd'),
(2, 'Murty', 800000, 'FrontEnd'),
(3, 'AnuRadha', 900000, 'DBAdmin');

SELECT * FROM employees;

ALTER TABLE employee RENAME TO employees;

INSERT INTO employees(id, name, salary, department)
VALUES
(4, 'RamMohan', 1000000, 'Tester'),
(5, 'Dinnu', 1100000, 'HR');

SELECT name FROM employees WHERE salary >= 800000;

SELECT * FROM employees WHERE department = 'Backend';

SELECT COUNT(id), department
FROM employees
GROUP BY department;

SELECT department, AVG(salary)
AS Average_Salary FROM employees
GROUP BY department;

SELECT name FROM employees 
ORDER BY salary DESC;

INSERT INTO  employees VALUES(6, 'Annu', 1200000, 'HR');
INSERT INTO  employees VALUES(7, 'Sameer', 1500000, 'BackEnd');

SELECT SUM(salary) AS "Total_Salary"
FROM employees
WHERE department = 'HR';

SELECT MAX(salary) AS "Max_Salary" FROM employees;

UPDATE employees 
SET salary = 750000 WHERE name = 'Sravan';

SELECT id, name, salary, department FROM employees WHERE name = 'Sravan';

DELETE from employees WHERE department = 'Tester';
