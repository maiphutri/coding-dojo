// Get 1 to 255
function get1to255() {
  var arr = [];
  for (var i=0; i < 255; i++) {
    arr[i] = i+1;
  }
  return arr;
}
console.log(get1to255());

// Get even 1000
function getEven1000() {
  var sum = 0;
  for (var i=2; i < 1001; i += 2) {
    sum += i;
  }
  return sum;
}
console.log(getEven1000()); // 250500

// Sum odd 5000
function sumOdd5000() {
  var sum = 0;
  for (var i=1; i < 5001; i += 2) {
    sum += i;
  }
  return sum;
}
console.log(sumOdd5000()); // 6250000

// Iterate an array 
function iterateArray(arr) {
  var sum = arr[0];
  for (var i=1; i < arr.length; i++) {
    sum += arr[i];
  }
  return sum;
}
console.log(iterateArray([1,2,5])); // 8
console.log(iterateArray([-5,2,5,12])); // 14

// Find max
function findMax(arr) {
  var max = arr[0];
  for (var i=1; i < arr.length; i++) {
    if (arr[i] > max) {
      max = arr[i];
    }
  }
  return max;
}
console.log(findMax([-3,3,5,7])); // 7

// Find average
function findAverage(arr) {
  var sum = 0;
  for (var i=0; i < arr.length; i++) {
    sum += arr[i];
  }
  return sum / arr.length;
}
console.log(findAverage([1,3,5,7,20])); // 7.2

// Array odd
function arrayOdd() {
  var arr = [];
  for (var i=1; i < 51; i += 2) {
    arr.push(i);
  }
  return arr;
}
console.log(arrayOdd());

// Greater than Y
function greaterThanY(arr, y) {
  var count = 0;
  for (var i=0; i < arr.length; i++) {
    if (arr[i] > y) {
      count++;
    }
  }
  return count;
}
console.log(greaterThanY([1, 3, 5, 7], 3)); // 2

// Squares
function squares(arr) {
  for (var i=0; i < arr.length; i++) {
    arr[i] = arr[i] * arr[i];
  }
  return arr;
}
console.log(squares([1,5,10,-2])); // [1, 25, 100, 4]

// Negatives
function negatives(arr) {
  for (var i=0; i < arr.length; i++) {
    if (arr[i] < 0) {
      arr[i] = 0;
    }
  }
  return arr;
}
console.log(negatives([1,5,10,-2])); // [1, 5, 10, 0]

// Max/Min/Avg
function maxMinAvg(arr) {
  var max = arr[0];
  var min = arr[0];
  var sum = arr[0];
  var result = [];
  for (var i=1; i < arr.length; i++) {
    sum += arr[i];
    if (arr[i] > max) {
      max = arr[i];
    } else if (arr[i] < min){
      min = arr[i];
    }
  }
  result.push(max);
  result.push(min);
  result.push(sum / arr.length);
  return result;
}

console.log(maxMinAvg([1,5,10,-2])) // [10, -2, 3.5]

// Swap Values
function swapValues(arr) {
  if (arr.length < 2) {
    console.log("Invalid array");
  }
  var first = arr[0];
  var last  = arr[arr.length - 1];
  arr[0] = last;
  arr[arr.length - 1] = first;
  return arr;
}
console.log(swapValues([1,5,10,-2])) // [-2, 5, 10, 1]

// Number to String
function numberToString(arr) {
  for (var i=0; i < arr.length; i++) {
    if (arr[i] < 0) {
      arr[i] = "Dojo";
    }
  }
  return arr;
}
console.log(numberToString([-1,-3,2])) // ["Dojo", "Dojo", 2]
