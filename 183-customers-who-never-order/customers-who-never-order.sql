# Write your MySQL query statement below
SELECT name as Customers FROM Customers as c LEFT JOIN Orders as o
ON c.id = o.customerID 
WHERE c.id IS NOT NULL && o.id IS NULL;