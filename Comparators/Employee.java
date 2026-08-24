import java.time.LocalDate;
import java.util.*;

public class Employee implements Comparable<Employee> {
    private int employeeId;
    private String name;
    private String department;
    private double salary;
    private int age;
    private LocalDate joiningDate;
    private double rating;

    public Employee(int employeeId, String name, String department,
            double salary, int age, LocalDate joiningDate, double rating) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
        this.joiningDate = joiningDate;
        this.rating = rating;
    }

    // 1. Sort by name (natural alphabetical order using a Comparator, not
    // Comparable)
    // @Override
    // public int compareTo(Employee e2)
    // {
    // Employee e1 = this;
    // return e1.name.compareTo(e2.name);
    // }

    // 2. Sort by salary, descending
    // @Override
    // public int compareTo(Employee e2) {
    // Employee e1 = this;
    // if (e1.salary > e2.salary)
    // return -1;
    // return 1;
    // }

    // 3. Give preference: name starts with "A" on top AND salary > 100000, sorted
    // by salary descending

    // @Override
    // public int compareTo(Employee e2) {
    // Employee e1 = this;
    // if (e1.name.startsWith("A") && e2.name.startsWith("A")) {
    // if (e1.salary > 100000 && e2.salary > 100000) {
    // return Double.compare(e2.salary, e1.salary);
    // }
    // if (e1.salary > 100000) {
    // return -1;
    // }
    // if (e2.salary > 100000) {
    // return 1;
    // }
    // return Double.compare(e2.salary, e1.salary);
    // }
    // if (e1.name.startsWith("A") && e1.salary > 100000) {
    // return -1;
    // }
    // if (e2.name.startsWith("A") && e2.salary > 100000) {
    // return 1;
    // }
    // return Double.compare(e2.salary, e1.salary);
    // }

    // 4. Sort by department, then by name within each department
    // @Override
    // public int compareTo(Employee e2) {
    // Employee e1 = this;
    // if (e1.department.equals(e2.department)) {
    // return e1.name.compareTo(e2.name);
    // }
    // return e1.department.compareTo(e2.department);
    // }

    // 5. Sort by age, ascending

    // @Override
    // public int compareTo(Employee e2) {
    // Employee e1 = this;
    // return Integer.compare(e1.age, e2.age);
    // }

    // 6. Sort by joining date, oldest employee (earliest date) first

    // 7. Sort by rating descending, then by salary descending as a tiebreaker
    // @Override
    // public int compareTo(Employee e2) {
    // Employee e1 = this;
    // if (e1.rating == e2.rating) {
    // return Double.compare(e2.salary, e1.salary);
    // }
    // return Double.compare(e2.rating, e1.rating);
    // }

    // Getters
    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return name + " | " + department + " | ₹" + salary + " | age " + age + " | joined " + joiningDate;
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee(1, "Aarav", "Engineering", 120000, 29, LocalDate.of(2021, 3, 15), 4.5),
                new Employee(2, "Anika", "Sales", 95000, 34, LocalDate.of(2019, 7, 1), 3.8),
                new Employee(3, "Bhavya", "Engineering", 135000, 41, LocalDate.of(2015, 1, 10), 4.9),
                new Employee(4, "Chirag", "Marketing", 88000, 25, LocalDate.of(2022, 11, 5), 4.1),
                new Employee(5, "Aditi", "Sales", 110000, 30, LocalDate.of(2020, 6, 20), 4.6),
                new Employee(6, "Aman", "Engineering", 102000, 27, LocalDate.of(2021, 9, 12), 3.9),
                new Employee(7, "Divya", "Marketing", 75000, 23, LocalDate.of(2023, 2, 1), 4.0),
                new Employee(8, "Aryan", "Sales", 140000, 38, LocalDate.of(2016, 4, 18), 4.7)));

        Collections.sort(employees);
        System.out.println(employees);
    }
}