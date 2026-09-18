/*
var hoisting -> var declared variables are hoisted at the top of their function
*/

// Example : 
function foo() {
    console.log(x); // This is not going to throw a reference error // because var is functional scoped 
    // var x = 10 below makes something like this var x; declare here 
    if (true) {
        var x = 10;
    }
    console.log(x);
}

foo()

/*

function foo() {
    if (true) {
        console.log(x);
        var x = 10;
    }
}

foo();


The above can be conceptually written as 


function foo() {
    var x;  // early declarations here

    if (true) {
        console.log(x); // undefined
        x = 10;
    }
}

*/




/*
Another  Example
*/

function foo3() {
    var x = 10;

    function innerFoo() {
        var y = 20;

        console.log(x);
        console.log(y);
    }

    innerFoo();

    // console.log(y); // Reference Error
}

foo3();

