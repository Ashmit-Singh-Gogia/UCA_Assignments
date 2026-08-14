function constructStudent(name, age, email, marks) {
    this.name = name;
    this.age = age;
    this.email = email;
    this.marks = marks;
};

const student1 = new constructStudent("name1", 12, "name1@gmail.com", 12)
const student2 = new constructStudent("name2", 22, "name2@gmail.com", 78)

student1.__proto__.mood = "Happy";

student1.__proto__.percentage = function () {
    return (this.marks / 1000) * 100
}

console.log(constructStudent.prototype)
console.log(student1.mood)
console.log(student2.mood)
console.log(student1.percentage())

// Prototype Chaining is basically when one object is created using the same proto behaviour
// then they have a link together

// obj2 = Object.create(obj1) creates the same proto of obj1 into the obj2
// obj2 = Object.assign({} , obj1) in this case only values are copied and hence the proto behaviour of both obj1 and obj2 will be different


student3 = Object.create(student2)
console.log(student3.__proto__ == student2.__proto__)   // why not working
