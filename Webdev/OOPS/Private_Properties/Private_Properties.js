class ConstructorStudent {
    #percentage

    constructor(name, age, email, marks) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.marks = marks; // not relevant for a privare property
    }

    setPercentage = () => {
        this.#percentage = (this.marks / 1000) * 100;
    }

    getPercentage = () => {
        this.setPercentage();
        return this.#percentage;
    }
}
const student1 = new ConstructorStudent("Ashu", 13, "ashu@gmail.com", 67)
console.log(student1)
// console.log(student1.#marks);  // not accessible
// console.log(student1.#percentage);   // not accessible

console.log(student1.getPercentage())
