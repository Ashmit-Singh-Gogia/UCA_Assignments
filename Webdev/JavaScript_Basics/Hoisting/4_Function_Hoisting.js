/*
//Block 1

foo1();

In simple words function declarations are hoisted , So this works

function foo1() {
    console.log("foo1 is called");
}

*/

/*
Function Expressions
*/


/*
//Block 2

foo2();

Because of the function expression it is declared like var foo2; and this is a not declared as a function
TypeError: foo is not a function

var foo2 = function () {
    console.log("foo2 is called");
}

*/



//Block 3

/*

foo3(); // Reference error

let foo3 = function () {
    console.log("foo3 is called")
};

*/
