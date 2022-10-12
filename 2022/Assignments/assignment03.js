function GCD(x, y) {
  x = Math.abs(x);
  y = Math.abs(y);
  while(y) {
    let t = y;
    y = x % y;
    x = t;
  }
  let result = document.getElementById("03B");
  result.value = x;
}

function sumDigits() {
    let value = document.getElementById("n").value,
        sum = 0;

  while (value) {
      sum += value % 10;
      value = Math.floor(value / 10);
  }
  
  let result = document.getElementById("result");
  result.value = sum;
}

function fullName() {
  let title = document.getElementById("title").value,
  fname = document.getElementById("fname").value,
  lname = document.getElementById("lname").value,
  s = document.getElementById("s").value,
  Fullname = `${title}. ${fname} ${lname}, ${s}`;
  
  let name = document.getElementById("03D");
  name.value = Fullname;
}

var tb1 = document.getElementById('tic');

function AA(){
  let aa = document.getElementById("03D");
  aa.value = x;
}
function AB(){
  
}
function AC(){
  
}
function BA(){
  
}
function BB(){
  
}
function BC(){
  
}
function CA(){
  
}
function CB(){
  
}
function CC(){
  
}
