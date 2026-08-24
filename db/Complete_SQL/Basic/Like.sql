--  % percent wildcard matches zero, one, or more characters
--  _ underscore wildcard matches a single character.

-- LIKE 'Kim%'	match a string that starts with Kim
-- LIKE '%er'	match a string that ends with er
-- LIKE '%ch%'	match a string that contains ch
-- LIKE 'Le_'	match a string that starts with Le and is followed by one character e.g., Les, Len…
-- LIKE '_uy'	match a string that ends with uy and is preceded by one character e.g., guy
-- LIKE '%are_'	match a string that includes the string are and ends with one character.
-- LIKE '_are%'	match a string that includes the string are, starts with one character and ends with any number of characters.

-- NOT LIKE 
-- To negate the result of a LIKE operator, you use the NOT operator:



Use SQL_Tutorial;

-- The following query uses the LIKE operator to find all employees with the first names starting with the string Da :
Select first_name , last_name from employees Where first_name Like 'Da%' Order by first_name;

-- The following statement uses the LIKE operator to find employees whose first names end with er:
Select first_name , last_name from employees Where first_name Like '%er';

-- The following query uses the LIKE operator to find employees whose first names contain the word an:
Select first_name , last_name from employees Where first_name Like '%an%';

-- The following query uses the LIKE operator to find employees whose first names start with Jo and are followed by two characters:
Select first_name , last_name from employees Where first_name Like 'Jo__';

-- The following query uses the LIKE operator with the % and _ wildcard characters to find employees whose first names start with any number of characters then 'are' amd then followed by a single character:
Select first_name , last_name from employees Where first_name Like '%are_';

-- The following example uses the NOT LIKE operator to find all employees whose first names start with the letter S but not start with Sh:
Select first_name , last_name from employees Where first_name Like 'S%' and first_name Not Like 'Sh%';
