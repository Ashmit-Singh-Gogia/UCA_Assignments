/*
A generator can pause and resume execution.

function* foo() {
    yield 1;
    yield 2;
    yield 3;
}

The * makes it a generator function.
*/



/*
// Block 1
function* generatorFunction(initialValue) {
    console.log("Called the function with intial Value ", initialValue);

    const x1 = yield 109;

    console.log("Inside the generator function after yield x1 ", x1);

    const x2 = yield 204;

    console.log("Inside the generator function after yield x2 ", x2);

    const x3 = yield 308;

    console.log("Inside the generator function after yield x3 ", x3);

}

var generator = generatorFunction(100);

for (let i = 0; i < 3; i++) {
    const x = generator.next();
    console.log(x);
}


*/

/*
// Block 2

function* test() {
    yield 10;
    yield 20;
    yield 30;
}

const g = test();

console.log(g.next());
console.log(g.next());
console.log(g.next());
console.log(g.next());

*/


/*

// Block 3

function* test() {
    const x = yield 10;
    console.log(x);
}

const g = test();

console.log(g.next());
console.log(g.next(99));

*/



/*

// Block 4

function* sumGenerator(initialValue) {
    let sum = initialValue;

    while (true) {
        const x = yield sum;
        if (typeof x === "number") {
            sum += x;
        }
    }

}

const g = sumGenerator(0);

console.log(g.next());       // 0
console.log(g.next(5));      // 5
console.log(g.next(10));     // 15
console.log(g.next(20));     // 35                  


*/