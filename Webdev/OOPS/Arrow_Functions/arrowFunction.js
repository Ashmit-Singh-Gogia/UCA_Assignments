// function declaration provided hoisting
console.log(multiplyBy2(2));

function multiplyBy2(item) {
    return item * 2;
}


// arrow function hoisting depends on let / var / const 
// console.log(multiplyBy2Arrow(2));

// var multiplyBy2Arrow = (item) => {
//     return item * 2;
// }


function outerFunction() {
    console.log(this);
    this.normalFunction = function () {
        console.log(this); // refers to the object which called it
        function innerNormalFunc() {
            console.log("this inside normal inner function", this);
        }
        innerNormalFunc();
    }
    this.arrowFunction = () => {
        console.log(this); // refers to the parent context
        function innerArrowFunc() {
            console.log("this inside arrow function", this);
        }
        innerArrowFunc();
    }
}

const obj1 = new outerFunction();

obj1.normalFunction();
obj1.arrowFunction();