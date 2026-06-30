# Write your MySQL query statement below
Select Department, e.name as Employee, A.Salary FROM
Employee as e,
(SELECT e.departmentId, d.name as Department, MAX(salary) as Salary
FROM Employee as e INNER JOIN Department as d On e.departmentId = d.id
GROUP BY e.departmentId, d.name) as A
WHERE e.departmentId = A.departmentId && e.salary = A.Salary;