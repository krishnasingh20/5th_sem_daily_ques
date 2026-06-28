CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
    SELECT salary FROM
    (
        SELECT  salary, DENSE_RANK() OVER (ORDER BY salary DESC) as rn FROM
        (
            SELECT DISTINCT salary FROM Employee
        ) as e
    ) as A
    WHERE rn = N
  );
END