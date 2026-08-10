CREATE DATABASE Week5_uca;
USE Week5_uca;


CREATE TABLE Employee(
	e_id int Primary Key,
    e_name varchar(40) not null,
	dept_name varchar(40) not null , 
    salary int
);

Insert into Employee (e_id , e_name , dept_name , salary)
VALUES 
(1 , "Ram" , "HR" , 10000),
(2 , "Amrit" , "MRKT" , 20000),
(3 , "Ravi" , "HR" , 30000),
(4 , "Nitin" , "MRKT" , 40000),
(5, "Varun" , "IT" , 50000);

SELECT * FROM EMPLOYEE;

-- sub query -> Employee with max salary
SELECT e_name from Employee Where salary = (SELECT MAX(salary) FROM EMPLOYEE);

-- All salaries except max
SELECT e_name , salary from Employee where salary <> (SELECT MAX(salary) FROM EMPLOYEE);

-- 2nd highest salary from Employee 
Select MAX(salary) from Employee Where salary <> (SELECT MAX(salary) from Employee);

-- name of employee with 2nd highest salary
Select e_name from Employee where salary = (Select MAX(salary) from Employee Where salary <> (SELECT MAX(salary) from Employee));


Select dept_name , Count(dept_name) as "Count of Employees" from Employee group by dept_name;

-- Write a query to display all dept names where number of employees are equal to 2
Select dept_name from Employee group by dept_name having Count(*) = 2;

-- Write a query to display all employee names who work in dept where number of employees are equal to 2
Select e_name from Employee Where dept_name in (Select dept_name from Employee group by dept_name having Count(*) = 2);


-- Write a query to diplay highest salary dept wise and name of employee who is taking that salary
select e_name , salary from Employee where salary in (Select Max(salary) from Employee group by dept_name);
