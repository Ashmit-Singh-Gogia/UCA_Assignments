Create DataBase If not Exists SQL_Tutorial;
USE SQL_Tutorial;

CREATE TABLE regions (
	region_id INT (11) AUTO_INCREMENT PRIMARY KEY,
	region_name VARCHAR (25) DEFAULT NULL
);

CREATE TABLE countries (
	country_id CHAR (2) PRIMARY KEY,
	country_name VARCHAR (40) DEFAULT NULL,
	region_id INT (11) NOT NULL,
	FOREIGN KEY (region_id) REFERENCES regions (region_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE locations (
	location_id INT (11) AUTO_INCREMENT PRIMARY KEY,
	street_address VARCHAR (40) DEFAULT NULL,
	postal_code VARCHAR (12) DEFAULT NULL,
	city VARCHAR (30) NOT NULL,
	state_province VARCHAR (25) DEFAULT NULL,
	country_id CHAR (2) NOT NULL,
	FOREIGN KEY (country_id) REFERENCES countries (country_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE jobs (
	job_id INT (11) AUTO_INCREMENT PRIMARY KEY,
	job_title VARCHAR (35) NOT NULL,
	min_salary DECIMAL (8, 2) DEFAULT NULL,
	max_salary DECIMAL (8, 2) DEFAULT NULL
);

CREATE TABLE departments (
	department_id INT (11) AUTO_INCREMENT PRIMARY KEY,
	department_name VARCHAR (30) NOT NULL,
	location_id INT (11) DEFAULT NULL,
	FOREIGN KEY (location_id) REFERENCES locations (location_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE employees (
	employee_id INT (11) AUTO_INCREMENT PRIMARY KEY,
	first_name VARCHAR (20) DEFAULT NULL,
	last_name VARCHAR (25) NOT NULL,
	email VARCHAR (100) NOT NULL,
	phone_number VARCHAR (20) DEFAULT NULL,
	hire_date DATE NOT NULL,
	job_id INT (11) NOT NULL,
	salary DECIMAL (8, 2) NOT NULL,
	manager_id INT (11) DEFAULT NULL,
	department_id INT (11) DEFAULT NULL,
	FOREIGN KEY (job_id) REFERENCES jobs (job_id) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (department_id) REFERENCES departments (department_id) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (manager_id) REFERENCES employees (employee_id)
);

CREATE TABLE dependents (
	dependent_id INT (11) AUTO_INCREMENT PRIMARY KEY,
	first_name VARCHAR (50) NOT NULL,
	last_name VARCHAR (50) NOT NULL,
	relationship VARCHAR (25) NOT NULL,
	employee_id INT (11) NOT NULL,
	FOREIGN KEY (employee_id) REFERENCES employees (employee_id) ON DELETE CASCADE ON UPDATE CASCADE
);




-- 1. REGIONS (4 rows)
INSERT INTO regions (region_name) VALUES 
('Europe'), 
('Americas'), 
('Asia'), 
('Middle East and Africa');

-- 2. COUNTRIES (25 rows)
INSERT INTO countries (country_id, country_name, region_id) VALUES 
('UK', 'United Kingdom', 1), ('DE', 'Germany', 1), ('FR', 'France', 1), 
('IT', 'Italy', 1), ('ES', 'Spain', 1), ('NL', 'Netherlands', 1), 
('CH', 'Switzerland', 1), ('BE', 'Belgium', 1), ('US', 'United States', 2), 
('CA', 'Canada', 2), ('MX', 'Mexico', 2), ('BR', 'Brazil', 2), 
('AR', 'Argentina', 2), ('CL', 'Chile', 2), ('JP', 'Japan', 3), 
('CN', 'China', 3), ('IN', 'India', 3), ('AU', 'Australia', 3), 
('SG', 'Singapore', 3), ('KR', 'South Korea', 3), ('EG', 'Egypt', 4), 
('ZA', 'South Africa', 4), ('NG', 'Nigeria', 4), ('AE', 'United Arab Emirates', 4), 
('SA', 'Saudi Arabia', 4);

-- 3. LOCATIONS (7 rows)
INSERT INTO locations (street_address, postal_code, city, state_province, country_id) VALUES 
('123 Main St', '10001', 'New York', 'NY', 'US'),
('456 Elm St', '94016', 'San Francisco', 'CA', 'US'),
('789 Maple Ave', 'W1D 1AL', 'London', 'Greater London', 'UK'),
('101 Sakura St', '100-0001', 'Tokyo', 'Tokyo', 'JP'),
('202 Hauptstr', '10115', 'Berlin', 'Berlin', 'DE'),
('303 King St', '2000', 'Sydney', 'NSW', 'AU'),
('404 Bay St', 'M5H 2N2', 'Toronto', 'ON', 'CA');

-- 4. Insert Jobs with EXPLICIT IDs
INSERT INTO jobs (job_id, job_title, min_salary, max_salary) VALUES 
(1, 'President', 20000.00, 40000.00),
(2, 'Vice President', 15000.00, 30000.00),
(3, 'Manager', 10000.00, 20000.00),
(4, 'Sales Representative', 6000.00, 12000.00),
(5, 'IT Professional', 5000.00, 10000.00),
(6, 'HR Representative', 4000.00, 9000.00),
(7, 'Accountant', 4000.00, 9000.00),
(8, 'Clerk', 3000.00, 6000.00),
(9, 'Marketing Specialist', 4000.00, 9000.00),
(10, 'Data Analyst', 5000.00, 10000.00),
(11, 'Consultant', 6000.00, 12000.00);

-- 5. Insert Departments with EXPLICIT IDs
INSERT INTO departments (department_id, department_name, location_id) VALUES 
(1, 'Executive', 1), (2, 'Sales', 2), (3, 'IT', 3), 
(4, 'Human Resources', 4), (5, 'Finance', 5), (6, 'Marketing', 6), 
(7, 'Research & Development', 7), (8, 'Support', 1), (9, 'Operations', 2), 
(10, 'Legal', 3), (11, 'Logistics', 4);

-- 6. EMPLOYEES (40 rows)
-- Note: Manager IDs reference previously inserted employees to prevent constraint errors.
INSERT INTO employees (first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id, department_id) VALUES 
('Steven', 'King', 'sking@test.com', '515.123.4567', '2015-06-17', 1, 24000.00, NULL, 1),
('Neena', 'Kochhar', 'nkochhar@test.com', '515.123.4568', '2016-09-21', 2, 17000.00, 1, 1),
('Lex', 'De Haan', 'ldehaan@test.com', '515.123.4569', '2017-01-13', 2, 17000.00, 1, 1),
('Alexander', 'Hunold', 'ahunold@test.com', '590.423.4567', '2018-01-03', 3, 9000.00, 2, 3),
('Bruce', 'Ernst', 'bernst@test.com', '590.423.4568', '2018-05-21', 5, 6000.00, 4, 3),
('David', 'Austin', 'daustin@test.com', '590.423.4569', '2019-06-25', 5, 4800.00, 4, 3),
('Valli', 'Pataballa', 'vpatabal@test.com', '590.423.4560', '2019-02-05', 5, 4800.00, 4, 3),
('Diana', 'Lorentz', 'dlorentz@test.com', '590.423.5567', '2020-02-07', 5, 4200.00, 4, 3),
('Nancy', 'Greenberg', 'ngreenbe@test.com', '515.124.4569', '2015-08-17', 3, 12000.00, 2, 5),
('Daniel', 'Faviet', 'dfaviet@test.com', '515.124.4169', '2016-08-16', 7, 9000.00, 9, 5),
('John', 'Chen', 'jchen@test.com', '515.124.4269', '2017-09-28', 7, 8200.00, 9, 5),
('Ismael', 'Sciarra', 'isciarra@test.com', '515.124.4369', '2018-09-30', 7, 7700.00, 9, 5),
('Jose', 'Urman', 'jurman@test.com', '515.124.4469', '2019-03-07', 7, 7800.00, 9, 5),
('Luis', 'Popp', 'lpopp@test.com', '515.124.4567', '2019-12-07', 7, 6900.00, 9, 5),
('Den', 'Raphaely', 'draphael@test.com', '515.127.4561', '2015-12-07', 3, 11000.00, 3, 2),
('Alexander', 'Khoo', 'akhoo@test.com', '515.127.4562', '2016-05-18', 4, 3100.00, 15, 2),
('Shelli', 'Baida', 'sbaida@test.com', '515.127.4563', '2017-12-24', 4, 2900.00, 15, 2),
('Sigal', 'Tobias', 'stobias@test.com', '515.127.4564', '2018-07-24', 4, 2800.00, 15, 2),
('Guy', 'Himuro', 'ghimuro@test.com', '515.127.4565', '2019-11-15', 4, 2600.00, 15, 2),
('Karen', 'Colmenares', 'kcolmena@test.com', '515.127.4566', '2020-08-10', 4, 2500.00, 15, 2),
('Matthew', 'Weiss', 'mweiss@test.com', '650.123.1234', '2016-07-18', 3, 8000.00, 3, 8),
('Adam', 'Fripp', 'afripp@test.com', '650.123.2234', '2017-04-10', 8, 8200.00, 21, 8),
('Payam', 'Kaufling', 'pkauflin@test.com', '650.123.3234', '2018-05-01', 8, 7900.00, 21, 8),
('Shanta', 'Vollman', 'svollman@test.com', '650.123.4234', '2019-10-10', 8, 6500.00, 21, 8),
('Kevin', 'Mourgos', 'kmourgos@test.com', '650.123.5234', '2020-11-16', 8, 5800.00, 21, 8),
('Julia', 'Nayer', 'jnayer@test.com', '650.124.1214', '2017-07-16', 8, 3200.00, 22, 8),
('Irene', 'Mikkilineni', 'imikkili@test.com', '650.124.1224', '2018-09-28', 8, 2700.00, 22, 8),
('James', 'Landry', 'jlandry@test.com', '650.124.1334', '2019-01-14', 8, 2400.00, 22, 8),
('Steven', 'Markle', 'smarkle@test.com', '650.124.1434', '2020-03-08', 8, 2200.00, 22, 8),
('Laura', 'Bissot', 'lbissot@test.com', '650.124.5234', '2021-08-20', 8, 3300.00, 23, 8),
('Mozhe', 'Atkinson', 'matkinso@test.com', '650.124.6234', '2022-10-30', 8, 2800.00, 23, 8),
('James', 'Marlow', 'jmarlow@test.com', '650.124.7234', '2023-02-16', 8, 2500.00, 23, 8),
('TJ', 'Olson', 'tolson@test.com', '650.124.8234', '2023-04-10', 8, 2100.00, 23, 8),
('Jason', 'Mallin', 'jmallin@test.com', '650.127.1934', '2020-06-14', 8, 3300.00, 24, 8),
('Michael', 'Rogers', 'mrogers@test.com', '650.127.1834', '2021-08-26', 8, 2900.00, 24, 8),
('Ki', 'Gee', 'kgee@test.com', '650.127.1734', '2022-12-12', 8, 2400.00, 24, 8),
('Hazel', 'Philtanker', 'hphiltan@test.com', '650.127.1634', '2023-02-06', 8, 2200.00, 24, 8),
('Renske', 'Ladwig', 'rladwig@test.com', '650.121.1234', '2021-07-14', 9, 3600.00, 25, 6),
('Stephen', 'Stiles', 'sstiles@test.com', '650.121.2034', '2022-10-26', 9, 3200.00, 25, 6),
('John', 'Seo', 'jseo@test.com', '650.121.2019', '2023-02-12', 9, 2700.00, 25, 6);

-- 7. DEPENDENTS (30 rows)
INSERT INTO dependents (first_name, last_name, relationship, employee_id) VALUES 
('Penelope', 'King', 'Child', 1), ('Nick', 'King', 'Child', 1),
('Ed', 'Kochhar', 'Spouse', 2), ('Jennifer', 'Kochhar', 'Child', 2),
('Johnny', 'De Haan', 'Child', 3), ('Bette', 'De Haan', 'Spouse', 3),
('Grace', 'Hunold', 'Child', 4), ('Matthew', 'Hunold', 'Child', 4),
('Joe', 'Ernst', 'Child', 5), ('Anna', 'Ernst', 'Spouse', 5),
('Scott', 'Austin', 'Child', 6), ('Sarah', 'Austin', 'Spouse', 6),
('Tom', 'Pataballa', 'Child', 7), ('Chloe', 'Lorentz', 'Child', 8),
('Will', 'Greenberg', 'Spouse', 9), ('Sam', 'Greenberg', 'Child', 9),
('Katie', 'Faviet', 'Child', 10), ('Ben', 'Chen', 'Child', 11),
('Alice', 'Sciarra', 'Spouse', 12), ('Emma', 'Urman', 'Child', 13),
('Lily', 'Popp', 'Child', 14), ('David', 'Raphaely', 'Child', 15),
('Lucas', 'Khoo', 'Child', 16), ('Mia', 'Baida', 'Child', 17),
('Ethan', 'Tobias', 'Child', 18), ('Olivia', 'Himuro', 'Child', 19),
('Mason', 'Colmenares', 'Child', 20), ('Sophia', 'Weiss', 'Child', 21),
('Logan', 'Fripp', 'Child', 22), ('Avery', 'Kaufling', 'Child', 23);

