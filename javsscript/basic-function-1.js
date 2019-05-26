
function a(){
  return 35;
}
console.log(a())
//Predict: print 35
//Output: print 35

function a(){
  return 4;
}
console.log(a()+a());
//Predict: print 8
//Output: print 8

function a(b){
  return b;
}
console.log(a(2)+a(4));
//Predict: print 6
//Output: print 6

function a(b){
  console.log(b);
  return b*3;
}
console.log(a(3));
//Predict: print 3 and 9
//Output: print 3 and 9

function a(b){
  return b*4;
  console.log(b);
}
console.log(a(10));
//Predict: print 40
//Outpust: print 40

function a(b){
  if(b<10) {
      return 2;
  }
  else     {
      return 4;
  }
  console.log(b);
}
console.log(a(15));
//Predict: print 4
//Output: print 4

function a(b,c){
  return b*c;
}
console.log(10,3);
console.log( a(3,10) );
//Predict: print 10, 3 and 30
//Output: print 10, 3 and 30

function a(b){
  for(var i=0; i<10; i++){
      console.log(i);
  }
  return i;
}
console.log(3);
console.log(4);
//Predict: print 3 and 4
//Output: print 3 and 4

function a(){
  for(var i=0; i<10; i++){
      i = i + 2;
      console.log(i);
  }
}
a();
//Predict:  print 2, 5, 8, 11
//Output: print 2, 5, 8, 11

function a(b,c){
  for(var i=b; i<c; i++) {
     console.log(i);
 }
 return b*c;
}
a(0,10);
console.log(a(0,10));
//Predict: print 0,1,2,3,4,5,6,7,8,9,1,0,1,2,3,4,5,6,7,8,9,0
//Output: print 0,1,2,3,4,5,6,7,8,9,1,0,1,2,3,4,5,6,7,8,9,0

function a(){
  for(var i=0; i<10; i++){
     for(var j=0; j<10; j++){
         console.log(j);
     }
     console.log(i);
  }
}
//Predict: function not yet invoke
//Output: function not yet invoke

var z = 10;
function a(){
    var z = 15;
    console.log(z);
}
console.log(z);
//Predict: print 10
//Output: print 10

var z = 10;
function a(){
    var z = 15;
    console.log(z);
}
a();
console.log(z);
//Predict: print 15 and 10
//Output: print 15 and 10

