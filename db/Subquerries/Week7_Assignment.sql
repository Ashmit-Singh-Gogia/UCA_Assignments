Use SQL_Tutorial;

-- The Data we are working on is in ../Data.sql

-- The following example uses the GROUP BY clause to group the values in department_id column of the employees table:
Select department_id from employees Group By department_id;

-- The GROUP BY clause will be more useful when you use it with an aggregate function.

-- the following statement uses the GROUP BY clause with the COUNT function to count the number of employees by department:
Select department_id , Count(employee_id) From employees Group By department_id;


-- The following example returns the number of employees by department. And it uses an INNER JOIN clause to include the department name in the result:
SELECT d.department_name, COUNT(employee_id) headcount from employees e 

  
-- Select department_name , Count(employee_id) headcount From employees group by department_name; 