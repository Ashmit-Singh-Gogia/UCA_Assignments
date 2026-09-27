// for in loop

// on Arrays
let array1 = [9, 8, 7, 4, 3]
for (let index in array1) {
    console.log(`The value at ${index}: is ${array1[index]}`)
}

// on objects
let student = {
    name: "Ashmit singh",
    age: 20,
    email: "ashmit@gmail.com"
}

for (let key in student) {
    console.log(`The valye on ${key} is:  ${student[key]}`)
}


// for of loop -> it iterates over the value of the array

// on Arrays
let array2 = [9, 8, 7, 4, 3]

for (let value of array2) {
    console.log(`The current value is ${value}`)
}


// map function
let numbers = [9, 8, 7, 4, 3];
let doubled = numbers.map((value) => {
    return value * 2;
});
console.log(doubled);


// for each -> iterated over the values of the array and executes a function of on each value without returning a new array

let array3 = [9, 8, 7, 4, 3]


/*
array3.forEach(mulitplyBy2Callback);

// var mulitplyBy2Callback = (value) => {
//     console.log(`The current value is ${value * 2}`)
// }

// hoisting issue
*/

array3.forEach(mulitplyBy2Callback);

function mulitplyBy2Callback(value) {
    console.log(`The current value is ${value * 2}`)
}


// Arrays.some
let checkIfAnyEven = array3.some((item) => {
    return item % 2 == 0;
})

console.log(checkIfAnyEven)


// Arrays.every

let checkIfAllEven = array3.every((item) => {
    return item % 2 == 0;
})

console.log(checkIfAllEven)


// Array.find   -> Returns the first value it finds satisfying the condition
let array4 = [43, 53, 15, 74, 82, 34, 92]
let evenValue = array4.find((item) => {
    return item % 2 == 0;
});
console.log(evenValue)

// Array.findIndex  -> returns -1 if no item satifies
let evenValueIndex = array4.findIndex((item) => {
    return item % 2 == 0;
});
console.log(evenValueIndex)

// Array.filter

let array5 = [43, 53, 15, 74, 82, 34, 92]
let evenArray = array5.filter((item) => {
    return item % 2 == 0;
});
console.log(evenArray)