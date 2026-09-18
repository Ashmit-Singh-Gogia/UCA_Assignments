// Set -> Like an array but with unique values 

let arr1 = [1, 2, 3, 4, 2, 3, 2, 1, 2, 3, 4]
let set1 = new Set(arr1)
console.log(set1)

// add an element
set1.add(5)
console.log(set1)

// Set is a collection of unique elements
// Base data structure of set is object of Entries
// Entry is an array of 2 elements (key and value) and set has entries of entry

// delete an element
console.log(set1.delete(2))
console.log(set1)
console.log(set1.delete(2))
console.log(set1)


// has method
console.log(set1.has(2))
console.log(set1.has(5))

// entries method
console.log(set1.entries())


// set can havedynamic type of data
set1.add("name")
console.log(set1)
console.log(set1.entries())
