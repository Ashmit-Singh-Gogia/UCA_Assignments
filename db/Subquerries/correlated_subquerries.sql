CREATE DATABASE Week5_uca;
USE Week5_uca;

CREATE Table If not exists Emp (
	e_id int primary key,
    e_name varchar(40),
    address varchar(200)
);

INSERT INTO Emp
(e_id , e_name , address) VALUES
(1,"Ravi" , "Chandigarh"),
(2,"Varun" , "Delhi"),
(3,"Nitin" , "Pune"),
(4,"Robin" , "Bangalore"),
(5,"Ammy" , "Chandigarh");

CREATE TABLE IF NOT EXISTS Project(
	pid int primary key,
    e_id int,
	p_name varchar(40),
    location varchar(200)
);

ALter table Project 
ADD constraint fk_Project_emp 
Foreign key (e_id) references Emp(e_id);

-- Change a column name from pid to p_id and also change the type from int to varchar
ALter table Project 
change column pid p_id varchar(20);

Insert into Project (e_id , p_id , p_name , location)
VALUES
(1 , 'P1' , 'IOT' , 'Bangalore'),
(5 , 'P2' , 'BIG DATA' , 'Delhi'),
(3 , 'P3' , 'Retail' , 'Mumbai'),
(4 , 'P4' , 'Android' , 'Hyderabad');


-- Detail of emplyee whose address is either Delhi or chandigarh or pune
Select * from Emp Where address in ('Delhi' , 'Chandigarh' , 'Pune');

-- Find the name of Emps who are working on a project
-- using subquerries
Select e_name from Emp Where e_id in (Select e_id from Project);
-- or using joins
Select e.e_name from Emp e Inner Join Project p on e.e_id = p.e_id;

-- In / Not In / = is used in sub queries
-- Exists / Not Exists used in correlated nested queries

--  In nested queries first the inner query runs and
--  after it completly runs the output is used as input for the inner query and hence the inner query runs

-- In correlated nested subquerries The outer queries one row runs for the inner query for each row and so on for 2nd outer row .... then the final outer row


-- Find the name of Emps who are working on a project
--  using correlated subqueries
Select * from Emp Where exists(select * from Project where Emp.e_id = Project.e_id);

-- Another data set for this correlated subqueries
Create table if not exists Employee(
	e_id int primary key,
    name varchar(40),
    address varchar(40)
);

Insert into Employee (e_id , name , address)
VALUES
(1,'A' , 'Delhi'),
(2,'B' , 'Pune'),
(3,'A' , 'Chandigarh'),
(4,'B' , 'Delhi'),
(5,'C' , 'Pune'),
(6,'D' , 'Mumbai'),
(7,'E' , 'Hyderabad');

Create table if not exists Department(
	dept_id int primary key,
    dept_name varchar(40),
    e_id int
);

Alter table Department
Change column dept_id dept_id varchar(20);


Alter table Department
Add constraint Foreign key (e_id) references Employee(e_id);

Insert into Department (dept_id , dept_name , e_id)
VALUES
('D1' , 'HR' , 1),
('D2' , 'IT' , 2),
('D3' , 'MRKT' , 3),
('D4' , 'Testing' , 4);

-- Find all the employees who work in a department
Select * from Employee where exists(select * from Department where Department.e_id = Employee.e_id);


-- Same Query in nested subquerries / Correlated subquerries / Joins example for difference

-- Find all the employees details who work in a department 

-- Nested subquery
Select * from Employee where e_id in (Select e_id from Department);

-- Correlated subquery
Select * from Employee where exists (Select * from Department Where Department.e_id = Employee.e_id);

-- Joins
Select * from Employee e Inner Join Department d on e.e_id = d.e_id;
