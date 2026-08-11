Use Week5_uca;

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

-- Salary Above Overall Average
SELECT instructor_name FROM Instructor WHERE instructor_salary > (SELECT AVG(instructor_salary) FROM Instructor);

-- Correlated Subquery by Department
SELECT instructor_name FROM Instructor I1 WHERE instructor_salary > (SELECT AVG(instructor_salary) FROM Instructor I2 WHERE I2.dept_id = I1.dept_id);

-- Subquery with IN
SELECT student_name FROM Student WHERE dept_id IN (SELECT dept_id FROM Department WHERE dept_name = 'CS');

-- Greater Than ALL
SELECT instructor_name FROM Instructor WHERE instructor_salary > ALL (SELECT instructor_salary FROM Instructor WHERE dept_id = 1);

-- Greater Than ANY
SELECT instructor_name FROM Instructor WHERE instructor_salary > ANY (SELECT instructor_salary FROM Instructor WHERE dept_id = 1);
