// object literals
const student1 = {
    name: "Ashmit",
    age: 22,
    email: "ashmit@gmail.com"
}

const student2 = {
    name: "Shubh",
    age: 24,
    email: "shubh@gmail.com"
}


// factory function -> Used for creating objects dynamically
// factory functions have a very heavy problem like in every object we create they have no remlation among them 
// also there is a new instance of the exact same function (like in example the above percentage function ) cretaed for new objects

const createStudent = (name, age, mail, marks) => {
    maxMarks = 100
    return {
        name: name,
        age: age,
        mail: mail,
        percentage: function () {
            return (marks / maxMarks) * 100;
        }
    }
}

const student3 = createStudent("Rahul", 26, "rahul@gmail.com ", 97)

console.log(student3.name + " has got " + student3.percentage() + "% marks")

