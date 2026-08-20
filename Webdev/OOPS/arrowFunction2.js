// Difference betweeen function declaration and array function are
// 1. Hoisting (function declaration is hoisted but array function is not)
// 2. Syntax : Normal functions use the 'function' keyword while arrow functions use the '=>' operator
// 3. this keyword: For a normal function 'this' keyword refers to the object which called it 
// For an array function 'this' keyword is inherited from the parent context


// Arrow functions are not suitable for constructor functions
// When creating a class we should use arrow functions because they fix the problem of 'this' keyword in nested functions
// Becase in normal functions 'this' keyword refer to the object which called it
// but if some inner functions call such functions they are not pointing to our class objects
// But in case of arrow functions they are pointing to the same context, like their parents
// Hence they preserve the 'this' keyword
