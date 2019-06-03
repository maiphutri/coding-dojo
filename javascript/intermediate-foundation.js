// Sigma
function sigma(num) {
  var sum = 0;
  for (var i=1; i <= num; i++) {
    sum += i;
  }
  return sum;
}
console.log(sigma(3)); // 6

// Factorial
function factorial(num) {
  if (num < 1 || isNaN(num)) return "Invalid number";
  var result = 1;
  for (var i=num; i >= 1; i--) {
    result *= i;
  }

  return result;
}

console.log(factorial("dsds")); // "Invalid number"
console.log(factorial(3)); // 6

// Fibonacci
function fibonacci(num) {
  if (num === 0) return 0;
  if (num === 1) return 1;
  return fibonacci(num - 1) + fibonacci(num - 2);
}
console.log(fibonacci(4)); // 3
console.log(fibonacci(10)); // 55

// Array: Second-to-Last:
function secondToLast(arr) {
  if (arr.length < 2) {
    return null;
  } else {
    return arr[arr.length - 2];
  }
}
console.log(secondToLast([42, true, 4, "Liam", 7])); // "Liam"
cosonle.log(secondToLast([1])); // null

// Array: Nth-to-Last:
function nthToLast(arr, num) {
  if (arr.length < 2) {
    return null;
  } else {
    return arr[arr.length - num];
  }
}
console.log(nthToLast([5,2,3,6,4,9,7],3)); // 4
console.log(nthToLast([1])); // null

// Array: Second-Largest
function secondLargest(arr) {
  if (arr.length < 2) {
    return null;
  } else {
    var sortedArr = arr.sort((a, b) => a - b);
    console.log(sortedArr);
    return sortedArr[sortedArr.length - 2];
  }
}
console.log(secondLargest([42,1,4,3.14,7])); // 7

// Double Trouble
function doubleTrouble(arr) {
  var copyArr = arr.slice();
  var j = 0;
  var newArrLength = arr.length * 2;
  for (var i=0; i < newArrLength; i += 2) {
    arr[i] = copyArr[j];
    arr[i+1] = copyArr[j];
    j++;
  }
  return arr;
}
console.log(doubleTrouble([4, "Ulysses", 42, false])); // [4, 4, "Ulysses", "Ulysses", 42, 42, false, false]