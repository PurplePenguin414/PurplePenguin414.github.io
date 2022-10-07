function GCD(x, y) {
  if ((typeof x !== 'number') || (typeof y !== 'number')) 
    return false;
  x = Math.abs(x);
  y = Math.abs(y);
  while(y) {
    let t = y;
    y = x % y;
    x = t;
  }
  document.getElementById("out").innerHTML= x;
  return x;
}

function sumDigits() {
    let value = document.getElementById("n").value,
        sum = 0;

  while (value) {
      sum += value % 10;
      value = Math.floor(value / 10);
  }
  
  let rezultat = document.getElementById("result");
  rezultat.value = sum;
}

function fullName() {
  let title = document.getElementById("title").value,
  fname = document.getElementById("fName").value,
  lname = document.getElementById("lName").value,
  s = document.getElementById("s").value,
  Fullname = Fullname.concat(title, fname, lname, s);
  
  console.log(Fullname);
  
  document.getElementById("fullName").innerHTML= Fullname;
  
}

let tb1 = document.getElementById('tic');

