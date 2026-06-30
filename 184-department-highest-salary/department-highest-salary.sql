# Write your MySQL query statement below
Select Department, e.name as Employee, A.Salary FROM
Employee as e JOIN 
(SELECT e.departmentId, d.name as Department, MAX(salary) as Salary
FROM Employee as e JOIN Department as d On e.departmentId = d.id
GROUP BY e.departmentId, d.name) as A
ON e.departmentId = A.departmentId AND e.salary = A.Salary;