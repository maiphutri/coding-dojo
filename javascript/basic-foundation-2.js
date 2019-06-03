// Biggie Size
function biggieSize(arr) {
  for (var i=0; i < arr.length; i++) {
    if (arr[i] > 0) {
      arr[i] = "big";
    }
  }
  return arr;
}
console.log(biggieSize([-1,3,5,-5])); // [-1, "big", "big", -5]

// Print Low, Return High
function printLowReturnHigh(arr) {
  var max = arr[0];
  var min = arr[0];
  for (var i=1; i < arr.length; i++) {
    if ( arr[i] > max) {
      max = arr[i];
    } else if (arr[i] < min){
      min = arr[i];
    }
  }
  console.log(min);
  return max;
}
console.log(printLowReturnHigh([-1,3,5,-5])) // -5, 5

// Print One, Return Another
function printOneReturnAnother(arr) {
  console.log(arr[arr.length - 2]);
  for (var i=0; i < arr.length; i++) {
    if (arr[i] % 2 !== 0) {
      return arr[i];
      break;
    }
  }
}
console.log(printOneReturnAnother([1,2,3,4])) // 2, 3, 4, 1

// Double Vision
function doubleVision(arr) {
  var newarr = [];
  for (var i=0; i < arr.length; i++) {
    newarr[i] = arr[i] * 2;
  }
  return newarr;
}
console.log(doubleVision([1,2,3])) // [2,4,6]

// Count Positives 
function countPositives(arr) {
  var count = 0;
  for (var i=0; i < arr.length; i++) {
    if (arr[i] > 0) {
      count++;
    }
  }
  arr[arr.length - 1] = count;
  return arr;
}
console.log(countPositives([-1,1,1,1])) // [-1,1,1,3]

// Evens and Odds
function evensAndOdds(arr) {
  for (var i=0; i < arr.length - 2; i++) {
    if (arr[i] % 2 !== 0 && arr[i+1] % 2 !== 0 && arr[i+2] % 2 !== 0) {
      console.log("That's odd!")
    } else if (arr[i] % 2 == 0 && arr[i+1] % 2 == 0 && arr[i+2] % 2 == 0) {
      console.log("Even more so!")
    }
  }
}
evensAndOdds([1,3,5,6]); // "That's odd!"
evensAndOdds([2,4,6,1,2]); // "Even more so!"

// Increment the Seconds
function incrementTheSeconds(arr) {
  for (var i=0; i < arr.length; i++) {
    if (i % 2 !== 0) {
      arr[i] = arr[i] + 1;
    }
    console.log(arr[i]);
  }
  return arr;
}
incrementTheSeconds([1,2,3,4,5,6]) // 1, 3, 3, 5, 5 ,7

// Previous Lengths
function previousLengths(arr) {
  var p1 = arr[0];
  for (var i=1; i < arr.length; i++) {
    var p2 = arr[i];
    arr[i] = p1.length;
    p1 = p2

  }
  return arr;
}
console.log(previousLengths(["hello", "dojo", "awesome"])); // ["hello", 5, 4]

// Add Seven
function addSeven(arr) {
  var newarr = [];
  for (var i=0; i < arr.length; i++) {
    newarr.push(arr[i] + 7);
  }
  return newarr;
}
console.log(addSeven([1,2,3])); // [8,9,10]

// Reverse Array 
function reverseArray(arr) {
  for (var i=0; i < arr.length / 2; i++) {
    var temp = arr[i];
    arr[i] = arr[arr.length - i - 1];
    arr[arr.length - i - 1] = temp;
  }
  return arr;
}
console.log(reverseArray([3,1,6,4,2])); // [2,4,6,1,3]

// Outlook: Negative 
function allNegatives(arr) {
  var newarr = [];
  for (var i=0; i < arr.length; i++) {
    if (arr[i] > 0) {
      newarr[i] = arr[i] * -1;
    } else {
      newarr[i] = arr[i];
    }
  }
  return newarr;
}
console.log(allNegatives([1,-3,5])); // [-1, -3, -5]

// Always Hungry
function alwaysHungry(arr) {
  var nofood = false;
  for (var i=0; i < arr.length; i++) {
    if (arr[i] === "food") {
      console.log("yummy");
      nofood = true;
    }
  }
  if (!nofood) {
    console.log("I'm hungry");
  }
}
alwaysHungry([1, 2, 'food', 3]); // "yummy"
alwaysHungry([1,2,3,4]); // "I'm hungry"

// Swap Toward the Center
function swapTowardCenter(arr) {
  for (var i=0; i < arr.length / 2; i += 2) {
    var temp = arr[i];
    arr[i] = arr[arr.length - i - 1];
    arr[arr.length - i - 1] = temp;
  }
  return arr;
}

console.log(swapTowardCenter([1,2,3,4,5,6])); // [6, 2, 4, 3, 5, 1]
console.log(swapTowardCenter([true,42,"Ada",2,"pizza"])); // [true,42,"Ada",2,"pizza"]

// Scale the Array
function scaleArray(arr, num) {
  for (var i=0; i < arr.length; i++) {
    arr[i] = arr[i] * num;
  }
  return arr;
}
console.log(scaleArray([1,2,3], 3)); // [3, 6, 9]
