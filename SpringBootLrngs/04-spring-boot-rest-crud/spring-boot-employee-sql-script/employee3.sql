USE practise;

SELECT * FROM employees 
WHERE department IN ('HR', 'BackEnd', 'IT') 
AND department NOT IN ('Sales');

SELECT department, COUNT(*) AS Employee_Count
FROM employees
GROUP BY department
ORDER BY Employee_Count DESC;

SELECT * FROM employees
WHERE salary = (SELECT MIN(salary) FROM employees);