// Promise is a constructor function
// Promise object has 2 values: 
// - state -> can be pending , fulfilled or rejected
// - value -> can be a value or an error

const callbackFn = (resolve, reject) => {   // resolve and reject are callback functions
    console.log("Inside promise executor function !")
    const promiseSuccess = true;
    if (promiseSuccess) resolve("Success");
    if (!promiseSuccess) reject("rejectValue")

}

const promise1 = new Promise(callbackFn);
console.log(promise1)