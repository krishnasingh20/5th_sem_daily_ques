# Write your MySQL query statement below
SELECT e2.name FROM Employee as e1 LEFT JOIN Employee as e2 ON e1.managerId = e2.id
WHERE e2.id IS NOT NULL GROUP BY e2.id HAVING COUNT(*) >= 5;