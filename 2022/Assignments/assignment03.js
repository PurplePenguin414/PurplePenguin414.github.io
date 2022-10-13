function GCD() {

    let x = parseInt(document.getElementById("one").value);
    let y = parseInt(document.getElementById("two").value);

    if(typeof(x) != "number" || typeof(y) != "number") {
        document.getElementById("03B").value = "Please enter two numbers";
        return;
    }
        
    /* This snippet is borrowed from "w3resource.com" */
    x = Math.abs(x);
    y = Math.abs(y);

    while(y) {
        let t = y;
        y = x % y;
        x = t;
        }
    /* end of borrowed snippet  */
    document.getElementById("03B").value = x;
}
function sumDigits() {
    var value = document.getElementById("n").value,
        sum = 0;

  while (value) {
      sum += value % 10;
      value = Math.floor(value / 10);
  }
  
  var rezultat = document.getElementById("03C");
  rezultat.value = sum;
}
function fullName() {
    let s = document.getElementById("s").value;
    let fname = document.getElementById("fname").value;
    let lname = document.getElementById("lname").value;
    let title = document.getElementById("title").value;
    
    if(s == "none")
        s = "";

    if(fname.length > 0)
        fname += " ";
    if(lname.length > 0)
        lname += " ";
    if(title == "none")
        title = "";
    else title += " ";

    document.getElementById("03D").value = title + fname + lname + s;
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
