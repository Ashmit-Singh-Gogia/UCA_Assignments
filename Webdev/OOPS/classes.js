class ConstructorStudent {
    constructor(name, age, email, marks) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.marks = marks;
    }
    percentage() {
        return (this.marks / 1000) * 100
    }
}
const student1 = new ConstructorStudent("Ashu", 13, "ashu@gmail.com", 67)
console.log(student1.percentage())
console.log(student1)