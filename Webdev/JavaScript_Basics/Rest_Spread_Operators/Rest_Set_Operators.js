// rest operator
// spread operator


// spread operator is used to combine the elements of multiple arrays / objects
let arr1 = [1, 2, 3]
let arr2 = [4, 5, 6]
let arr3 = [...arr1, ...arr2]
console.log(arr3)

const studentPersonalDetails = {
    name: "Ashmit singh",
    age: 20,
    email: "ashmit9955@gmail.com"
}

const studentAcademicDetails = {
    college: "Chitkara Uni",
    age: 21
}
// in case of same keys the 2nd called one over writes the values
const studentDetails = {
    ...studentPersonalDetails,
    ...studentAcademicDetails
}

console.log(studentDetails)


// Rest operator -> Combines spreaded values into one data structure like array
const details = {
    name: "John Wick",
    age: 42,
    email: "John@gmail.com",
    college: "Boston Univeristy"
}

const { name, age, email } = details
console.log(name)
console.log(age)
console.log(email)

// Rest operator examples
function sum(...numbers) {
    let s = 0;
    for (let value of numbers) {
        s += value
    }
    return s;
}

console.log(sum(1, 2, 3, 4, 5))