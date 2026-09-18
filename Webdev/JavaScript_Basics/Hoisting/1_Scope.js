/*

var is functional scoped

*/

function foo1() {
    var x = 10;
    console.log("Value of x : ", x); // 10
}

// foo1();

/* 

console.log(x); // This throws a Reference error because x is declared using var
//  which is functional scoped and can be accessed only in the function foo

*/


/*

let and const are block scoped
A block is anything inside { } , Like: 


if (...) {
    // block
}

for (...) {
    // block
}

while (...) {
    // block
}


*/

if (true) {
    let x = 10;
    const y = 120;
    // console.log(x, y)    // 10 120
}

/*

console.log(x, y)

Reference error since x and y are block scoped and cant be 
accessed outside the if block they are defined in

*/



/*

Difference between var and (let and const)

*/

if (true) {
    var x = 100;
    let y = 30;
    const z = 20;
}


// console.log(x) // 100   // functional scoped
// console.log(y) // Reference error    // block scoped
// console.log(z) // Reference error   // block scoped



/*
Another Example
*/

var a = 2;  // Global a 

function foo() {
    var a;  // Local a and a is functional scoped

    console.log(a);
    a = 10;
    console.log(a);
    // var a; inside foo creates a separate local variable that shadows the global one.
    //  Any reads/writes to a inside foo only affect the local copy. The global a = 2 stays untouched throughout.
}

foo();

console.log(a);



console.log(num); // undefined by declared
// var declarations are hosted at the top of their function and hence they dont care about blocks
if (true) {
    var num = 0;
}
console.log(num)



