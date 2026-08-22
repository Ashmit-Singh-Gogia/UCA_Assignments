// Webstorage : Introduced in HTML5. 
// Used to store data in client side

// LocalStorage : Data is stored permanently until explicitly deleted
//SessionStorage : Data is stored for the duration of the session
//Cookie : Data is stored for the duration of the cookie

// Local Storage vs Session Storage 

// Local Storage: Permanently
// Session Storage: Temporary
// In detail

// Local Storage
// Set
localStorage.setItem("name", "Ashmit");
localStorage.setItem("age", 19);

// Get
console.log(localStorage.getItem("name"));
console.log(localStorage.getItem("age"));

// Remove
localStorage.removeItem("name");

// Clear
localStorage.clear();

// Session storage belongs to current tab ( current session only ) 
// while local storage belongs to same origin shared across all the tabs of same domain
// Data is not shared between tabs in case of session storage


// Cookies and local is same across all tabs for a domain
// But cookies are sent with every request to the server while local storage is not


// Local Storage and Session Storage both have a limit of 5mb while cookies have 4kb

// Local Storage key is domain related while session key is related to domain + current tab


// Cookies are sticky means they are sent with every request to the server while local storage is not
// cookies size is restricted to 4kb size because its sent with every request headers size is limited to 4kb

// main purpose of cookie is not storage but for authentication or identification of user
