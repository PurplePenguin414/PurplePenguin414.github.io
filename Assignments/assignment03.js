let elem = [];
// assign the entire table row for hole 1 to a variable, elem
// elem[1] = document.getElementById("1");

// display the number of children (all td elements)
// console.log(elem.children.length);
// display the content of the + button, which is the first child of the fifth element
// console.log(elem.children[4].children[0]); 

// assign a function to the + button
// elem[1].children[4].children[0].onclick = function(){add1(elem[1]);};

for(let i=1; i<=18; i++) {
  // console.log(i);
  elem[i] = document.getElementById(i.toString());
  elem[i].children[4].children[0].onclick = function(){add1(elem[i]);};
}

// create an "add1" function
function add1 (elem) {
  if(elem.children[2].innerHTML == "-") 
    elem.children[2].innerHTML = "1";
  else {
    let currentScore = elem.children[2].innerHTML;
    currentScore = Number.parseInt(currentScore);
    elem.children[2].innerHTML = currentScore + 1;
  }
}
for(let i=1; i<=18; i++) {
  // console.log(i);
  elem[i] = document.getElementById(i.toString());
  elem[i].children[4].children[1].onclick = function(){down1(elem[i]);};
}

// create an "down1" function
function down1 (elem) {
  if(elem.children[2].innerHTML == "+") 
    elem.children[2].innerHTML = "1";
  else {
    let currentScore = elem.children[2].innerHTML;
    currentScore = Number.parseInt(currentScore);
    elem.children[2].innerHTML = currentScore - 1;
  }
}
for(let i=1; i<=18; i++) {
  // console.log(i);
  elem[i] = document.getElementById(i.toString());
  elem[i].children[4].children[2].onclick = function(){Zero(elem[i]);};
}

// create an "Zero" function
function Zero (elem) {
  if(elem.children[2].innerHTML == "0") 
    elem.children[2].innerHTML = "1";
  else {
    let currentScore = elem.children[2].innerHTML;
    currentScore = Number.parseInt(currentScore);
    elem.children[2].innerHTML = currentScore = 0;
  }
}

for(let j=1; j<=18; j++) {
  // console.log(i);
  elem[j] = document.getElementById(j.toString());
  elem[j].children[4].children[3].onclick = function(){over(elem[j]);};
}

// create an "Over" function
function over (elem) { 
  if(elem.children[2].innerHTML == " ") {
    elem.children[3].innerHTML = score - par;}
  else {
    let par = elem.children[1].innerHTML;
    let score = elem.children[2].innerHTML;
    par = Number.parseInt(par);
    score = Number.parseInt(score);
    elem.children[3].innerHTML = score - par;
  }
}


let table00 = document.getElementById("table00");

let arr00 = create2dArray (table00) ;

let totalsRow = createTotalsRow(arr00);

appendTableRow(table00,"td",totalsRow[1],totalsRow[2],totalsRow[3]);

function create2dArray (tableid) {
  let arr = [];
  let rows = tableid.children[0].children.length;
  let cols = tableid.children[0].children[0].children.length;
  for(let i=1; i<rows; i++) {
    arr[i] = [];
    for(let j=1; j<cols; j++) {
      arr[i][j] = tableid.children[0].children[i].children[j].innerHTML;
    }
  }
  return arr;
}

function createTotalsRow(arr2d) {
  // initialize totals row
  let totalsRow = [0, 0, 0, 0];
  let rows = arr2d.length;
  let cols = arr2d[1].length;
  // skip row 0, the top row
  for(let i=1; i<rows; i++) {
    // skip column 0, the item column
    for(let j=1; j<cols; j++) {
      totalsRow[j] += Number.parseFloat(arr2d[i][j]);
    }
  }
  return totalsRow;
}

let obj00 = createObj (table00) ;

let totalsRowObj = createTotalsRowObj(obj00);

appendTableRow(table00,"td",
    totalsRowObj.col1,totalsRowObj.col2,totalsRowObj.col3);

function createObj (tableid) {
  let obj = {};
  let rows = tableid.children[0].children.length;
  let cols = tableid.children[0].children[0].children.length;
  for(let i=1; i<4; i++) {
    obj["row"+i] = {}; // use bracket notation
    for(let j=1; j<18; j++) {
      obj["row"+i]["col"+j] = 
        tableid.children[1].children[i].children[j].innerHTML;
    }
  }
  return obj;
}

function createTotalsRowObj(obj) {
  // initialize totals row object
  let totalsRowObj = {"col1":1, "col2":1, "col3":1};
  let rows = 4;
  let cols = 18;
  // skip row 0, the top row
  for(let i=1; i<4; i++) {
    // skip column 0, the item column
    for(let j=1; j<18; j++) {
      totalsRowObj["col"+j] += Number.parseFloat(obj["row"+i]["col"+j]);
    }
  }
  return totalsRowObj;
}

let main = document.getElementById("table00");

function appendTableRow (tableobj, col1, col2, col3) {
  // create text nodes
  let text1  = document.createTextNode(col1); 
  let text2  = document.createTextNode(col2);
  let text3  = document.createTextNode(col3);
  // create table divisions, "td" or "th"
  let th1    = document.getElementById("parTotal");
  let th2    = document.getElementById("scoreTotal");
  let th3    = document.getElementById("overTotal");
  // append text nodes to table divisions (columns)
  th1.appendChild(text1);
  th2.appendChild(text2);
  th3.appendChild(text3);
  // create table row
  let tr    = document.getElementById("totals");
  // append table divisions (columns) to table row
  tr.appendChild(th1);
  tr.appendChild(th2);
  tr.appendChild(th3);
  // append the row to the tbody element in the table
  tableobj.children[0].appendChild(tr);
}
