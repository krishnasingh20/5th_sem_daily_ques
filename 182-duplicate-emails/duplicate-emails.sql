# Write your MySQL query statement below
SELECT email as Email FROM (
    SELECT email, COUNT(*) as cnt FROM Person GROUP BY email HAVING cnt > 1
) as cm;