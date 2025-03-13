USE practise;

INSERT INTO employees(id, name, salary, department)
VALUES
(8, 'Priya', 950000, 'Marketing'),
(9, 'Rohan', 500000, 'Sales'),
(10, 'Kavya', 1200000, 'HR'),
(11, 'Nikhil', 700000, 'FrontEnd'),
(12, 'Deepika', 800000, 'BackEnd'),
(13, 'Rahul', 1350000, 'IT'),
(14, 'Sneha', 1400000, 'IT'),
(15, 'Akash', 600000, 'Marketing');

SELECT * FROM employees WHERE
salary > 800000 AND department IN ('HR', 'BackEnd');

SELECT department , SUM(salary) AS Total_Salary
FROM employees
GROUP BY department
HAVING  Total_Salary > 2000000;

SELECT name, salary
FROM employees
HAVING salary > (SELECT AVG(salary) FROM employees); 