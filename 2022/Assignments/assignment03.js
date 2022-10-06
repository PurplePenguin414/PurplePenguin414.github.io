function GCD(x, y) {
  if ((typeof x !== 'number') || (typeof y !== 'number')) 
    return false;
  x = Math.abs(x);
  y = Math.abs(y);
  while(y) {
    var t = y;
    y = x % y;
    x = t;
  }
  document.getElementById("out").innerHTML= x;
  return x;
}

function sumDigits() {
    var value = document.getElementById("n").value,
        sum = 0;

  while (value) {
      sum += value % 10;
      value = Math.floor(value / 10);
  }
  
  var rezultat = document.getElementById("result");
  rezultat.value = sum;
}
