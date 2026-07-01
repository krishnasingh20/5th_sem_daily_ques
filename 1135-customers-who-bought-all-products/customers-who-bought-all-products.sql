# Write your MySQL query statement below
SELECT customer_id FROM 
(SELECT DISTINCT customer_id, product_key FROM Customer) as A
GROUP BY customer_id HAVING COUNT(*) = (SELECT COUNT(*) as 'count' FROM Product);