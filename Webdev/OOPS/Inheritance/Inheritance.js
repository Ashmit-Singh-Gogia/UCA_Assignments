const arr1 = new Array(1, 23, 45, 56)

const multiplyBy2 = (item) => {
    return item * 2;
}

// iArray map function will call the multiplyBy2 function n times where n is the length of the array with array item as a 
// In this case it will call the multiplyBy2 function 4 times since the length of array arr1 is 4
arr1.map(multiplyBy2)


// Implement a custom map(customMap) function on the Array Constructor's prototype 
// this will behave as inbuilt map function but we will implement it from scratch just for better understanding of 
Array.prototype.customMap = function (callbackfunc) {
    let newArr = [];
    for (let i = 0; i < this.length; i++) {
        newArr.push(callbackfunc(this[i], i, this))
    }
    return newArr;
}
let resultArr = arr1.customMap(multiplyBy2)
console.log(resultArr)

// Imlpement the forEach custotm function 