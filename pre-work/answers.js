// Page 16 - Setting and Swapping
myNumber = 42;
myName = "Tri Mai";

var temp = myNumber;
myNumber = myName;
myName = temp;
console.log("My number: " + myNumber);
console.log("My name " + myName);

// Print -52 to 1066
for (let i = -52; i < 1067; i++) {
  console.log(i);
}

// Don't worry, Be Happy
function beCheerful() {
  console.log("good morning!")
}
for (let i = 1; i < 99; i++) {
  beCheerful();
}

// Multiples of Three - but Not All
for (let i = -300; i < 1; i++) {
  if (i === -3) {
    continue;
  } else if (i === -6) {
    continue;
  } else {
    console.log(i * 3);
  }
}

// Printing Integers with While
var number = 2000

while (number < 5280) {
  console.log(number);
  number++;
}

// You Say It’s Your Birthday
function guessMyBirthday(month, day) {
  const myBirthday = {
    month: 05,
    day: 25
  }

  if (month === myBirthday.month && day === myBirthday.day) {
    console.log("How did you know?")
  } else {
    console.log("Just another day....")
  }
}

guessMyBirthday(5,25); // "How did you know?"
guessMyBirthday(7,28); // "Just another day...."

// Leap Year
function isLeapYear(year) {
  if (isNaN(year)) return console.log("Invalid year input.");

  if (year % 4 === 0) {
    console.log(year + " is a leap year.")
  } else {
    console.log(year + " is not a leap year.")
  }
}

isLeapYear(50); // "50 is not a leap year."
isLeapYear(400); // "400 is a leap year."

// Print and Count
var count = 0;
var number = 512;

while (number < 4097) {
  console.log(number * 5);
  count++;
  number++;
}

console.log(count);

// Multiples of Six
var number = 1;

while (number < 10001) {
  console.log(number * 6);
  number++;
}

// Counting. the Dojo Way
for (let i = 1; i < 501; i++) {
  console.log(i);
  if (i % 5 === 0) {
    console.log("Coding" + (i % 10 === 0 ? " Dojo" : ""));
  }
}

// What Do You Know?
function logValue(incoming) {
  console.log(incoming);
}

// Whoa, That Sucker’s Huge…
var oddNumberArray = [];
var sum = 0;

for (let i = -299999; i < 300000; i = i + 2) {
  oddNumberArray.push(i);
  sum++;
}

console.log(sum);
console.log(oddNumberArray);

// Countdown by Fours
for ( let i = 2016; i > 0; i = i - 4) {
  console.log(i)
}

// Flexible Countdown
function flexibleCountdown(lowNum, highNum, mult) {

  for (let i = highNum; i > lowNum; i--) {
    if (i % mult === 0) {
      console.log(i);
    }
  }
}

flexibleCountdown(2,9,3);

// The Final Countdown
function finalCountdown(param1, param2, param3, param4) {
  var number = param2;

  while (number < param3) {
    if (number % param1 === 0 && number !== param4) {
      console.log(number);
    }
    number++;
  }
}

finalCountdown(3,5,17,9);

// Page 20 - Countdown
function countDown(number) {
  var result = [];

  for (let i = number; i > 0; i--) {
    result.push(i);
  }
  console.log(result);
  console.log("Array length: " + result.length);
}

countDown(8);

// Print and Return
function printAndReturn(array) {
  if (array.length === 2) {
    console.log(array[0]);
    return array[1];
  }
}

printAndReturn([7, 5]);

//First Plus Strength
function firstPlusStrength(array) {
  if (isNaN(array[0])) {
    console.log("First value is not a number");
  } else {
    return console.log(array[0] + array.length);
  }
}

// Values Greater than Second
var array = [1, 3, 5, 7, 9, 13];

var newarr = array.filter(num => num > array[1]);

console.log(newarr);
console.log("There are " + newarr.length + " numbers greater than " + array[1]);

// Values Greater than Second, Generalized
function valueGreaterSecond(array) {
  if (array.length < 2) return console.log("There is only one value");

  var newarr = array.filter(num => num > array[1]);

  console.log(newarr);
  console.log("There are " + newarr.length + " numbers greater than " + array[1]);
}

valueGreaterSecond([1]);
valueGreaterSecond([1,2,3,4,5,6]);

// Factorial 
function factorial(num) {
  if (num < 1 || isNaN(num)) return "Invalid number";
  var result = 1;
  for (var i=num; i >= 1; i--) {
    result *= i;
  }

  return result;
}

factorial("dsds");
factorial(3)

//PushFront
function pushFront(arr, num) {
  var newArr = [num];
  for (var i=0; i < arr.length; i++) {
    newArr[i+1] = arr[i];
  }
  return newArr;
}

pushFront([1], 5);

//PopFront
function popFront(arr) {
  var newArr = [];
  for (var i=1; i < arr.length; i++) {
    newArr[i-1] = arr[i];
  }
  return newArr;
}

var arrr = popFront([1,2,3]);
console.log(arrr);

//InsertAt
function insertAt(arr, index, val) {
  var newArr = [];
  var inserted = false;
  for(var i=0; i <= arr.length; i++) {
    if (i !== index && !inserted) {
      newArr[i] = arr[i];
    } else if(!inserted) {
      newArr[i] = val;
      newArr[i+1] = arr[i];
      inserted = true;
      i++
    } else {
      newArr[i] = arr[i-1]
    }
  }
  return newArr;
}

insertAt([1,2,3,4], 1, 10);

//RemoveAt
function removeAt(arr, index) {
  debugger
  var newArr = [];
  var removed = false;
  for (var i=0; i < arr.length; i++) {
    if(i !== index & !removed) {
      newArr[i] = arr[i];
    } else if (!removed){
      newArr[i] = arr[i+1];
      removed = true;
      i++;
    } else {
      newArr[i-1] = arr[i]
    }
    
  }
  return newArr;
}

removeAt([1,2,3,4], 1);

// Reverse Array
function reverseArray(arr) {
  var newArr = [];
  for (var i=arr.length-1; i >= 0; i--) {
    newArr.push(arr[i]);
  }
  return newArr;
}

reverseArray([1,2,3,4,5]);

// Remove Negatives
function removeNegatives(arr) {
  debugger
  var newArr = [];
  for (var i=0; i < arr.length; i++) {
    if (arr[0] > 0) {
      newArr[i] = arr[i];
    } else {
      
    }
  }
}

removeNegatives