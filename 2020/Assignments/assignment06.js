
// ===== GLOBAL VARIABLES =====

// default values
let loans = [
  { loan_year: 2020, loan_amount: 10000.0, loan_int_rate: 0.0453 },
  { loan_year: 2021, loan_amount: 10000.0, loan_int_rate: 0.0453 },
  { loan_year: 2022, loan_amount: 10000.0, loan_int_rate: 0.0453 },
  { loan_year: 2023, loan_amount: 10000.0, loan_int_rate: 0.0453 },
  { loan_year: 2024, loan_amount: 10000.0, loan_int_rate: 0.0453 }
];
//global variables
let loanWInterest = 0;
let int = 0;
let payments;

// ===== FUNCTIONS =====

// ----- Plain JavaScript Functions -----

// -------------------------------------------------------
//adds commas in thousands value
function toComma(value) {
  return value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

// -------------------------------------------------------
//adds dollar sign at the front of toComma
let toMoney = (value) => {
  return `\$${toComma(value.toFixed(2))}`;
};

// -------------------------------------------------------
//it saves it in local storage of that device
let saveForm = () => {
  localStorage.setItem(`as06`, JSON.stringify(loans));
};

// -------------------------------------------------------
//gets inside the localstorage and updates the form in that localstorage
let loadForm = () => {
  if (localStorage.getItem(`as06`) != null) {
    loans = JSON.parse(localStorage.getItem(`as06`));
    updateForm();
  } else {
    alert(`Error: no saved values`);
  }
};

// ----- JQUERY Functions -----

// -------------------------------------------------------
// display the entry form
function loadDoc() {
  // pre-fill defaults for first loan year
  var defaultYear = loans[0].loan_year; //pre filling the default year in the first year. Its declaring and initializing
  $("#loan_year0" + 1).val(defaultYear++); //Jquery selector, Increments default year in the first line
  var defaultLoanAmount = loans[0].loan_amount;
  $("#loan_amt0" + 1).val(defaultLoanAmount.toFixed(2)); //Jquery selector, setting default loan amount in first line
  var defaultInterestRate = loans[0].loan_int_rate;
  $("#loan_int0" + 1).val(defaultInterestRate); //Jquery selector, setting default InterestRate in first line
  var loanWInterest = loans[0].loan_amount * (1 + loans[0].loan_int_rate);
  $("#loan_bal0" + 1).text(toMoney(loanWInterest)); // Jquery selector, uses toMoney & setting default loanWInterest in first line

  // pre-fill defaults for other loan years
  // asking 2,3,4,5
  for (var i = 2; i < 6; i++) {
    $(`#loan_year0${i}`).val(defaultYear++); //increment year
    $(`#loan_year0${i}`).attr("disabled", "true"); //it cant be edited
    $(`#loan_year0${i}`).css({
      backgroundColor: "grey",
      color: "white"
    }); // makes it look disabled. makes background gray and white text
    $(`#loan_amt0${i}`).val(defaultLoanAmount.toFixed(2));
    $(`#loan_int0${i}`).val(defaultInterestRate);
    $(`#loan_int0${i}`).attr("disabled", "true");
    $(`#loan_int0${i}`).css({
      backgroundColor: "grey",
      color: "white"
    });
    loanWInterest = //keeps updating the interest to have the total
      (loanWInterest + defaultLoanAmount) * (1 + defaultInterestRate);
    $("#loan_bal0" + i).text(toMoney(loanWInterest)); //adds dollar signs and comma at balance
  } // end: "for" loop

  //all input fields: select contents on focus
  //highlight background yellow when clicked or in focus
  $("input[type=text]").focus(function () {
    $(this).select();
    $(this).css("background-color", "yellow");
  });
  //makes background white when it is deselected or in blur
  $("input[type=text]").blur(function () {
    $(this).css("background-color", "white");
    updateLoansArray();
  });

  // set focus to first year: messes up codepen
  // $("#loan_year01").focus();
} // end: function loadDoc()

// -------------------------------------------------------
function updateLoansArray() {
  //takes user input and change the data in loans array using regex

  // regex tester web site: https://www.regexpal.com/
  let yearP = /^(19|20)\d{2}$/; //has to be 19 or 20 at the start and followed by two numbers
  let amtP = /^([1-9][0-9]*)+(.[0-9]{1,2})?$/; //first digit has to start 1-9 and followed by none, one or more additional digits and then plus two or one decimal digit.
  let intP = /^(0|)+(.[0-9]{1,5})?$/; //have zero at the start have 1 to 5 decimal places
  let valid = true;

  //checks yearP matches the year pattern. background turns red if false
  if (!yearP.test($(`#loan_year01`).val())) {
    valid = false;
    $(`#loan_year01`).css("background-color", "red");
  }
  //checks if amtP matches the ammount pattern. background turns red if false
  for (i = 1; i < 6; i++) {
    if (!amtP.test($(`#loan_amt0${i}`).val())) {
      valid = false;
      $(`#loan_amt0${i}`).css("background-color", "red");
    }
  }
  //check if intP matches the interest rate pattern. background turns red if false
  if (!intP.test($(`#loan_int01`).val())) {
    valid = false;
    $(`#loan_int01`).css("background-color", "red");
  }

  //if users input are true then it updates the variables and form
  if (valid) {
    loans[0].loan_year = parseInt($("#loan_year01").val());
    for (var i = 1; i < 5; i++) {
      loans[i].loan_year = loans[0].loan_year + i;
    }
    for (i = 1; i < 6; i++) {
      let amt = parseFloat($(`#loan_amt0${i}`).val()).toFixed(2);
      loans[i - 1].loan_amount = amt;
    }
    let rate = parseFloat($("#loan_int01").val());
    for (i = 0; i < 5; i++) {
      loans[i].loan_int_rate = rate;
    }

    updateForm(); // only updates if inputs are valid then it will update the form
  } // end: if
} // end: function updateLoansArray()

//display the data in the entry form
//filling out the form and replacing the field witth correct computations
let updateForm = () => {
  loanWInterest = 0;
  let totalAmt = 0;
  for (i = 1; i < 6; i++) {
    $(`#loan_year0${i}`).val(loans[i - 1].loan_year);
    let amt = loans[i - 1].loan_amount;
    $(`#loan_amt0${i}`).val(amt);
    totalAmt += parseFloat(amt);
    $(`#loan_int0${i}`).val(loans[i - 1].loan_int_rate);
    loanWInterest =
      (loanWInterest + parseFloat(amt)) * (1 + loans[0].loan_int_rate);
    $("#loan_bal0" + i).text(toMoney(loanWInterest));
  }
  int = loanWInterest - totalAmt;
  $(`#loan_int_accrued`).text(toMoney(int)); //show the interest
}; // end: function updateForm()

// ----- ANGULAR -----
//creates variable app and assign value angular module
var app = angular.module("myApp", []);
app.controller("myCtrl", function ($scope) {
  $scope.payments = [];
  $scope.populate = function () {
    //populates the payments array

    updateForm(); 

    //payments
    let total = loanWInterest; //calculate total
    let iRate = loans[0].loan_int_rate;
    let r = iRate / 12;
    let n = 11;
    //loan payment formula
    let pay =
      12 * (total / (((1 + r) ** (n * 12) - 1) / (r * (1 + r) ** (n * 12)))); //formula to get computation with same payments for every period
    for (let i = 0; i < 10; i++) {
      //loop that calculate as the period increases
      total -= pay;
      let int = total * iRate;
      $scope.payments[i] = {
        year: loans[4].loan_year + i + 1,
        payment: toMoney(pay),
        amt: toMoney(int),
        ye: toMoney((total += int))
      };
    }
    //calculates the last payment with the last total balance
    $scope.payments[10] = {
      year: loans[4].loan_year + 11,
      payment: toMoney(total),
      amt: toMoney(0),
      ye: toMoney(0)
    };
  };
});
