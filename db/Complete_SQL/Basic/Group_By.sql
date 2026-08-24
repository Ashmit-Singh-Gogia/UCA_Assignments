-- The GROUP BY clause allows you to group rows based on values of one or more columns.
-- It returns one row for each group.

-- In practice, you often use the GROUP BY clause with an aggregate function such as MIN, MAX, AVG, SUM, or COUNT 
-- to calculate a measure that provides the information for each group.

Use SQL_Tutorial;

-- The Data we are working on is in ../Data.sql

-- The following example uses the GROUP BY clause to group the values in department_id column of the employees table:
Select department_id from employees Group By department_id;

-- The GROUP BY clause will be more useful when you use it with an aggregate function.

-- the following statement uses the GROUP BY clause with the COUNT function to count the number of employees by department:
Select department_id , Count(employee_id) From employees Group By department_id;


-- The following example returns the number of employees by department. And it uses an INNER JOIN clause to include the department name in the result:
--  department_name column is in departments table and the employees table have the employees 
Select department_name , Count(employee_id) From Employees e Inner Join departments d On e.department_id = d.department_id group by department_name;


-- To get the total salary per department, you apply the SUM function to the salary column and group employees by the department_name column as follows:
--  salary column in employees and department_name departments
--  Join the two tables
--  per keyword says we need group by
Select d.department_name , Sum(e.salary) From Employees e Inner Join departments d On e.department_id = d.department_id group by d.department_name;



-- find departments with headcounts are greater than 5 show dept names also along with it 
Select d.department_id , d.department_name ,Count(e.employee_id) headCount From employees e Inner Join departments d On e.department_id = d.department_id group by e.department_id having Count(e.employee_id) > 5;



-- The following query returns the minimum, maximum, and average salary of employees in each department with department_name.
Select department_name , Min(salary) , Max(salary) , Avg(salary) From employees e Inner Join departments d On e.department_id = d.department_id group by department_name;
