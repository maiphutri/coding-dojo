//Given an array and a value Y, count and print the number of array values greater than Y.
function arrGreaterThanY(arr, y) {
  var count = 0;
  for (var i=0; i < arr.length; i++) {
    if (arr[i] > y) {
      console.log(arr[i]);
      count++;
    }
  }
  return count;
}

console.log("count: " + arrGreaterThanY([1,2,3,4,5], 2))

//Given an array, print the max, min and average values for that array.
function maxMinAverage(arr) {
  var max = arr[0];

  for (var i=1; i < arr.length; i++) {
    if (arr[i] > max) {
      max = arr[i];
    }
  }
}

maxMinAverage([5,4,2,1])
maxMinAverage([1,2,3,4])