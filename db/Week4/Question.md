10. Setup Data (use this for the setup-based Join questions)
Department: (1,'CS'), (2,'Electronics'), (3,'Mechanical')

Instructor: (101,'Dr. Rao',1,95000), (102,'Dr. Mehta',2,88000),
            (103,'Dr. Iyer',1,72000), (104,'Dr. Sen',3,60000)

Student: (1,'Aarav',1,'2003-05-14'), (2,'Diya',1,'2003-08-22'),
         (3,'Kabir',2,'2003-01-30'), (4,'Meera',3,'2003-03-11'),
         (5,'Rohan',1,'2003-07-19')

Course: (201,'DBMS',1,101), (202,'OS',1,103), (203,'Circuits',2,102), (204,'Thermo',3,104)

Enrollment: (1,201,'A'), (1,202,'B'), (2,201,'A'), (3,203,'B'), (5,201,'C')
Your submission:

Marked as completed.

Expected answer:

Mark this task as completed.

Review: Completed

11. Removing a Table Completely
Which command removes a table's structure entirely, along with all its data, so the table no longer exists?

Your submission:

DROP

Expected answer:

DROP

Review: Correct

12. Removing Specific Rows
Which of these commands can be used together with a WHERE clause to remove only specific rows from a table?

Your submission:

DELETE

Expected answer:

DELETE

Review: Correct

13. Implied Constraints on Primary Key
Which constraint automatically implies both NOT NULL and UNIQUE at the same time?

Your submission:

PRIMARY KEY

Expected answer:

PRIMARY KEY

Review: Correct

14. Foreign Key Violation
Given the schema above, what happens if you try to insert a new Student row with dept_id = 9, and no Department with dept_id = 9 exists?

Your submission:

The insertion fails with a foreign key constraint violation

Expected answer:

The insertion fails with a foreign key constraint violation

Review: Correct

15. Auto-Filling a Column
Which constraint automatically fills in a value for a column when no value is explicitly provided during INSERT?

Your submission:

DEFAULT

Expected answer:

DEFAULT

Review: Correct

16. ON DELETE CASCADE Behavior
If Course.dept_id has a foreign key defined with ON DELETE CASCADE referencing Department, what happens when a Department row is deleted?

Your submission:

All Course rows referencing that dept_id are deleted automatically

Expected answer:

All Course rows referencing that dept_id are deleted automatically

Review: Correct

17. Adding a New Column
Which statement correctly adds a new column called email to the Student table?

Your submission:

ALTER TABLE Student ADD COLUMN email VARCHAR(100);

Expected answer:

MODIFY Student ADD email VARCHAR(100);

Review: Incorrect

18. What INNER JOIN Returns
What does an INNER JOIN between two tables return?

Your submission:

Only the rows where there is a match in both tables

Expected answer:

Only the rows where there is a match in both tables

Review: Correct

19. What LEFT JOIN Preserves
When you run a LEFT JOIN between Student and Enrollment, which rows are guaranteed to appear in the result, even if there is no matching enrollment?

Your submission:

Every row from the Student table

Expected answer:

Every row from the Enrollment table

Review: Incorrect

20. Counting Rows: LEFT JOIN
Using the setup data above, how many total rows are returned by: SELECT * FROM Student LEFT JOIN Enrollment ON Student.student_id = Enrollment.student_id;

Your submission:

6

Expected answer:

6

Review: Correct

21. Counting Rows: INNER JOIN
Using the setup data above, how many total rows are returned by: SELECT * FROM Student INNER JOIN Enrollment ON Student.student_id = Enrollment.student_id;

Your submission:

5

Expected answer:

5

Review: Correct

22. Counting Rows: CROSS JOIN
Using the setup data above, how many rows are returned by: SELECT * FROM Student CROSS JOIN Course;

Your submission:

20

Expected answer:

20

Review: Correct

23. LEFT JOIN vs RIGHT JOIN
What is the relationship between a LEFT JOIN and a RIGHT JOIN?

Your submission:

A RIGHT JOIN can be rewritten as a LEFT JOIN by swapping the table order

Expected answer:

A RIGHT JOIN can be rewritten as a LEFT JOIN by swapping the table order

Review: Correct

24. Counting Pairs: SELF JOIN
Using the setup data above, and a self-join that finds pairs of students in the same department (S1.student_id < S2.student_id), how many such pairs exist in total?

Your submission:

3

Expected answer:

3

Review: Correct

25. FULL OUTER JOIN in MySQL
Why do you typically need to simulate a FULL OUTER JOIN in MySQL using a UNION of a LEFT JOIN and a RIGHT JOIN?

Your submission:

Because MySQL does not natively support FULL OUTER JOIN syntax

Expected answer:

Because MySQL does not natively support FULL OUTER JOIN syntax

Review: Correct