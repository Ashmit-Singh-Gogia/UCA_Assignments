// Constructor functions
function constructStudent(name, age, email, marks) {
    this.name = name;
    this.age = age;
    this.email = email;
    this.marks = marks;
};

// Static property — shared across all instances, accessed via constructStudent.maxMarks
constructStudent.maxMarks = 100;

// When we create a function in js , js automatically gives it a prototype property,
// when we use this prototype property to create an object of that function we get a __proto__ property to the object
// this __proto__ is same for all the objects we create from that function's prototype

const student1 = new constructStudent("Ashmit", 21, "ash@mail.com", 100)
const student2 = new constructStudent("Beckham", 24, "beck@mail.com", 67)

console.log(student1.__proto__ === student2.__proto__)  // this is the relation between the objects


// Add properties to a prototype of a function

constructStudent.prototype.percentage = function () {
    return (this.marks / constructStudent.maxMarks) * 100
}
console.log(student2.percentage())
