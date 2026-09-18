

/*
// Block 1
function foo1() {
    console.log(x); // Reference error
    let x = 10; // similar behaviour with const also
}

foo1();
*/


/*
// Block 2


function foo2() {

    console.log(y); // y is declared in a block below so can not be referred out side the block // Reference Error

    if (true) {
        let y = 20;
        console.log(y);
    }
    console.log(y) // Reference Error
}

foo2();

*/


/*

//Block 3

if (true) {
    console.log(x); // Reference error
    let x = 10;
}

*/