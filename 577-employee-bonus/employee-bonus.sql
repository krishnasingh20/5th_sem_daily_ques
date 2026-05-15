# Write your MySQL query statement below
SELECT name, bonus FROM
Employee as e LEFT JOIN Bonus as b ON e.empId = b.empId
WHERE b.bonus IS NULL || b.bonus < 1000;