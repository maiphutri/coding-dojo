var users = [{name: "Michael", age:37}, {name: "John", age:30}, {name: "David", age:27}];

// print/log John's age?
for (var i=0; i < users.length; i++) {
  if (users[i].name === "John") {
    console.log("John's age: " + users[i].age);
  }
}

// print/log the name of the first object?
console.log(users[0].name);

// print/log the name and age of each user using a for loop?
for (var i=0; i < users.length; i++) {
  console.log(users[i].name + " - " + users[i].age);
}