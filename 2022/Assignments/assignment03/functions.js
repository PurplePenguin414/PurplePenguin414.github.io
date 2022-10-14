/* define your functions here */
function calculateTotal(quantity, price) {
    return quantity * price;
}

function outputCartRow(item, total) {
    //Prompt user for tax & shipping threshold
    let tax = parseFloat(prompt("What is the tax?", "0.10"));
    let shipMinimum = parseFloat(prompt("What is the shipping threshold?", "300"));
    
    // select the HTML table 
    //Save for later
    let subtotal = 0;
	let tbl = document.getElementsByClassName('table-fill')[0];
    
    let i = 0;
    while(i < cart.length) {

    let row = tbl.insertRow(i + 1); // skip first row (column headings)
  
    // create an empty cell for each column to appear in HTML table
    let cell0 = row.insertCell(0); // image	
    let cell1 = row.insertCell(1); // product
    let cell2 = row.insertCell(2); // quantity
    let cell3 = row.insertCell(3); // price
    let cell4 = row.insertCell(4); // totalAmount

    let quantity = cart[i].quantity;
    let price = cart[i].product.price.toFixed(2);
    let curTotal = calculateTotal(quantity, price).toFixed(2);
    subtotal += parseFloat(curTotal);
  
    // populate HTML table with data 
    cell0.innerHTML = "<img src = images/" + cart[i].product.filename + ">"; // image
    cell1.innerHTML = cart[i].product.title; // product
    cell2.innerHTML = quantity;              // quantity
    cell3.innerHTML = "$" + price;                 // price
    cell4.innerHTML = "$" + curTotal;    // total
    i++;

    //Align Text and adjust image table cell
    cell0.style.width = "140px";
    cell2.style.textAlign = "center";
    cell3.style.textAlign = "center";
    cell4.style.textAlign = "right";
    }
    
    let shipping = (subtotal < shipMinimum) ? 40 : 0

    //After page load, update bottom of table with correct total amounts
    let totals = document.getElementsByClassName('totals');
    totals[0].getElementsByTagName("td")[1].innerHTML = "$" + subtotal.toFixed(2);
    totals[1].getElementsByTagName("td")[1].innerHTML = "$" + (subtotal * tax).toFixed(2);
    totals[2].getElementsByTagName("td")[1].innerHTML = "$" + shipping.toFixed(2);
    totals[3].getElementsByTagName("td")[1].innerHTML = "$" + parseFloat(subtotal + (subtotal * tax) + shipping).toFixed(2);
    
    
}

outputCartRow();







        
