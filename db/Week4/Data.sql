CREATE Database uca;
use uca;

# Create Tables

CREATE TABLE if not exists Department(
	Dept_id INT Primary Key,
    Dept_name Varchar(40) not null
);

Create table if not exists Instructor (
	instructor_id Int Primary Key,
    instructor_name Varchar(40) not null,
    instructor_salary Int,
    dept_id int References Department(dept_id)
);

Create table if not exists Student (
	student_id Int Primary Key,
    student_name Varchar(40) not null,
    dept_id Int References Department(dept_id),
	dob DATE
);


Create table if not exists Course(
	course_id Int Primary Key,
    course_name Varchar(40) not null,
    dept_id Varchar(40) not null,
    instructor_id Int REFERENCES Instructor(instructor_id)
);


Create table if not exists Enrollment(
	student_id int references Student(student_id),
    course_id int references Course(course_id),
    grade Varchar(1) not null,
    Primary key (student_id , course_id)
);

# Feed Data

Insert into Department(dept_id , dept_name)
Values 
(1 , 'CS'),
(2,'Electronics'),
(3,'Mechanical');

Insert into Instructor(instructor_id , instructor_name , instructor_salary , dept_id)
VALUES
(101,'Dr. Rao',95000 , 1), 
(102,'Dr. Mehta',88000, 2),
(103,'Dr. Iyer',72000, 1), 
(104,'Dr. Sen',60000 , 3);


Insert into Student(student_id , student_name , dept_id , dob)
Values 
(1,'Aarav',1,'2003-05-14'),
(2,'Diya',1,'2003-08-22'),
(3,'Kabir',2,'2003-01-30'),
(4,'Meera',3,'2003-03-11'),
(5,'Rohan',1,'2003-07-19');


Insert into Course (course_id , course_name , dept_id , instructor_id)
Values 
(201,'DBMS',1,101), (202,'OS',1,103), (203,'Circuits',2,102), (204,'Thermo',3,104);


Insert into Enrollment(student_id , course_id , grade)
VALUES
(1,201,'A'), (1,202,'B'), (2,201,'A'), (3,203,'B'), (5,201,'C');


-- Comment 1 This Query Fails with Foreign key constraint
Insert into student (student_id ,  student_name , dept_id , dob)
Values
(6,'Riya' , 9 , '2003-07-19'); 
-- Comment 1


-- Queries

SELECT * FROM Student s LEFT JOIN Enrollment e
On s.student_id = e.student_id;

SELECT * FROM Student s1 JOIN Student s2 
On s1.dept_id = s2.dept_id Where s1.student_id < s2.student_id;



-- Comment 2 Full outer join is not supported in My SQL 
--  We do it using Union of Left outer join and Right outer join
-- Comment 2


SELECT * FROM Student s 
LEFT OUTER JOIN Enrollment e 
On s.student_id = e.student_id
Union 
SELECT * FROM Enrollment e 
LEFT OUTER JOIN Student s 
On s.student_id = e.student_id;
