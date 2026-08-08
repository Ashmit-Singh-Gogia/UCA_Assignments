let obj1 = {
    name: "Ashmit Singh",
    age: 22,
    email: "ashmit9955@gmail.com"
}

// Object using create
var obj2 = Object.create(obj1)
console.log(obj2.__proto__);

// Object assign method is used for merging 2 objects into one object
//  and it also returns the same object with same address as the first parameter

let obj3 = { name: "Rishabh" }
console.log("ob3 before assign method " + obj3);

let obj4 = { age: 21 }

Object.assign(obj3, obj4)
console.log("obj3 after assign method ")
console.log(obj3)

console.log("obj4 after assign method ")
console.log(obj4)