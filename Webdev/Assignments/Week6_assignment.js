function createProduct(name) {
    return {
        name: name,

        purchaseProduct: function () {
            return `Hello ${this.name}`;
        }
    };
}

const product1 = createProduct("Product1");
const product2 = createProduct("Product2");

const obj1 = {
    age: 12
}


product1.__proto__.rating = 4;

console.log(product2.rating)
console.log(obj1.rating)    // they are all inhereting from the global Object prototype

console.log(product1.purchaseProduct.prototype == product2.purchaseProduct.prototype)


// return statement missing
const result = [1, 2, 3].map(num => {
    num * 2;
});

console.log(result);


const nums = [10, 20, 30];
console.log(
    nums.findIndex(num => num === 1000)
);