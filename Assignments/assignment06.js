// ---------- Global variables ----------

// use "var" keyword so code works in CodePen

// Covid19api variables
var URL = "https://api.covid19api.com/summary";
var covidJson;
var covidJsObj;
var newConfirmedOver1000;

// AJAX variable
var xhttp;

// Chart.js variables

// modified from : https://www.sitepoint.com/introduction-chart-js-2-0-six-examples/
// "ctx" is the canvas HTML element where the chart is rendered in the browser
var ctx = 
  document.getElementById('myChart').getContext('2d');
// "chartData" includes the graph AND the formatting, including title, legend, axes, etc.
var chartData = {
  type: 'bar',
  data: {
    labels: ['M', 'T', 'W', 'T', 'F', 'S', 'S'],
    datasets: [{
      label: 'apples',
      data: [12, 19, 3, 17, 6, 3, 7],
      backgroundColor: "rgba(255,0,0,0.4)"
    }, {
      label: 'oranges',
      data: [2, 29, 5, 5, 2, 3, 10],
      backgroundColor: "rgba(255,140,0,0.4)"
    }]
  },
  options: {
    title: {
      display: true,
      text: 'Apples and Oranges'
    },
    scales: {
      yAxes: [{
        ticks: {
          // logarithmic scale ignores maxTicksLimit
          maxTicksLimit: 11,
          callback: function(label, index, labels) {
            return (   label/1000 > 9 
                    || label/1000 == 1 
                    || label/1000 == 0.1 
                    || label/1000 == 0.01) 
              ? label/1000+'k' :  "";
          }
        },
        scaleLabel: {
          display: true,
          labelString: '1k = 1000'
        },
        // logarithmic scale ignores maxTicksLimit
        type: "logarithmic"
      }]
    }
  }
};
// var myChart = new Chart(ctx, chartData); 

// ---------- loadContent() function ----------

// Note: you can't execute API data dependent code outside the loadContent() function because the code might execute before the AJAX call responds, that is, it might execute before the variable, covidJson, is initialized with data from the API. Example below.
// console.log(covidJson.Global.NewConfirmed); // error 

// code below modified from: 
// https://www.w3schools.com/js/js_ajax_intro.asp

function loadContent() {
  xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 
        && this.status == 200) {
      
      covidJson = this.responseText;
      covidJsObj = JSON.parse(covidJson);
      newConfirmedOver1000 = [];
      
      // convert object to 2d array
      var popArr = []
      for([p, v] of Object.entries(populations)) 
        popArr[p] = v
      // console.log( popArr )
      
	    for (let c of covidJsObj.Countries) {
        if (c.NewConfirmed > 5000) {
          newConfirmedOver1000.push({ 
            "Slug": c.Slug, 
            "NewConfirmed": c.NewConfirmed, 
            "NewDeaths": c.NewDeaths,
            "Population": popArr[c.Slug]
          });
        }
      }
      newConfirmedOver1000 = _.orderBy(newConfirmedOver1000, "NewDeaths", "desc");

      chartData.data.datasets[0].backgroundColor 
        = "rgba(100,100,100,0.4)"; // gray
      chartData.data.datasets[1].backgroundColor 
        = "rgba(255,0,0,0.4)"; // red
      chartData.data.datasets[0].label  
        = 'new cases';
      chartData.data.datasets[1].label  
        = 'new deaths';
      chartData.data.labels  
        = newConfirmedOver1000.map( (x) => x.Slug );
      chartData.data.datasets[0].data  
        = newConfirmedOver1000.map( 
          (x) => x.NewConfirmed );
      chartData.data.datasets[1].data  
        = newConfirmedOver1000.map( 
          (x) => x.NewDeaths );
      chartData.options.title.text 
        = "Covid 19 Hotspots" ;
      myChart = new Chart(ctx, chartData); 

    } // end if
    
  }; // end xhttp.onreadystatechange = function()
  
  xhttp.open("GET", URL, true);
  xhttp.send();
  
} // end function loadContent() 

// data from: https://en.wikipedia.org/wiki/List_of_countries_and_dependencies_by_population
var populations = {
  'china' : 1405137440,
'india' : 1369152434,
'united-states' : 330578332,
'indonesia' : 269603400,
'pakistan' : 220892331,
'brazil' : 212281095,
'nigeria' : 206139587,
'bangladesh' : 169575884,
'russia' : 146748590,
'mexico' : 127792286,
'japan' : 125880000,
'philippines' : 109376023,
'congo' : 101935800,
'egypt' : 101126063,
'ethiopia' : 100829000,
'vietnam' : 96483981,
'iran' : 83914898,
'turkey' : 83154997,
'germany' : 83122889,
'france' : 67146000,
'united-kingdom' : 66796807,
'thailand' : 66571530,
'italy' : 60026546,
'south-africa' : 59622350,
'tanzania' : 57637628,
'myanmar' : 54817919,
'south-korea' : 51841786,
'colombia' : 50372424,
'kenya' : 47564296,
'spain' : 47329981,
'argentina' : 45376763,
'algeria' : 43900000,
'sudan' : 42957030,
'ukraine' : 41723998,
'uganda' : 41583600,
'iraq' : 40150200,
'poland' : 38352000,
'canada' : 38229409,
'morocco' : 36063063,
'uzbekistan' : 34501586,
'saudi-arabia' : 34218169,
'afghanistan' : 32890171,
'malaysia' : 32703180,
'peru' : 32625948,
'angola' : 31127674,
'ghana' : 30955202,
'mozambique' : 30066648,
'nepal' : 29996478,
'yemen' : 29825968,
'venezuela' : 28435943,
'ivory-coast' : 26453542,
'madagascar' : 26251309,
'australia' : 25690614,
'north-korea' : 25550000,
'cameroon' : 24348251,
'taiwan' : 23568378,
'niger' : 23196002,
'sri-lanka' : 21803000,
'burkina-faso' : 21510181,
'mali' : 20250833,
'chile' : 19458310,
'romania' : 19317984,
'kazakhstan' : 18806296,
'malawi' : 18449828,
'zambia' : 17885422,
'ecuador' : 17601388,
'netherlands' : 17525931,
'syria' : 17500657,
'guatemala' : 16858333,
'senegal' : 16705608,
'chad' : 16244513,
'somalia' : 15893219,
'zimbabwe' : 15473818,
'cambodia' : 15288489,
'south-sudan' : 13249924,
'rwanda' : 12663116,
'guinea' : 12559623,
'burundi' : 12309600,
'benin' : 12114193,
'haiti' : 11743017,
'tunisia' : 11708370,
'bolivia' : 11633371,
'belgium' : 11539878,
'cuba' : 11193470,
'jordan' : 10804332,
'greece' : 10724599,
'czech-republic' : 10699142,
'dominican-republic' : 10448499,
'sweden' : 10367232,
'portugal' : 10295909,
'azerbaijan' : 10095900,
'hungary' : 9769526,
'belarus' : 9408400,
'united-arab-emirates' : 9366829,
'tajikistan' : 9313800,
'honduras' : 9304380,
'israel' : 9272700,
'papua-new-guinea' : 8935000,
'austria' : 8915382,
'switzerland' : 8632703,
}

// step2 
// new array 
// loop through all covidJsObj.Countries[i] 
// push all info i need
/*
var newArray = [] 
for (let i=0; i<covidJsObj.Countries.length; i++) {
  newArray.push({
    "Slug": "\"" + covidJsObj.Countries[i].Slug + "\"",
    "TotalConfirmed": covidJsObj.Countries[i].TotalConfirmed
    // continue here...
  })
  
}
*/
// some code below derived from Quinn Friebe's work at 
// http://webp.svsu.edu/~qefriebe/cis255/as06/as06.html
	
	
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
let loanWithInterest = 0;
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
  var loanWithInterest = loans[0].loan_amount * (1 + loans[0].loan_int_rate);
  $("#loan_bal0" + 1).text(toMoney(loanWithInterest)); // Jquery selector, uses toMoney & setting default loanWithInterest in first line

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
    loanWithInterest = //keeps updating the interest to have the total
      (loanWithInterest + defaultLoanAmount) * (1 + defaultInterestRate);
    $("#loan_bal0" + i).text(toMoney(loanWithInterest)); //adds dollar signs and comma at balance
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

// -------------------------------------------------------
//display the data in the entry form
//filling out the form and replacing the field witth correct computations
let updateForm = () => {
  loanWithInterest = 0;
  let totalAmt = 0;
  for (i = 1; i < 6; i++) {
    $(`#loan_year0${i}`).val(loans[i - 1].loan_year);
    let amt = loans[i - 1].loan_amount;
    $(`#loan_amt0${i}`).val(amt);
    totalAmt += parseFloat(amt);
    $(`#loan_int0${i}`).val(loans[i - 1].loan_int_rate);
    loanWithInterest =
      (loanWithInterest + parseFloat(amt)) * (1 + loans[0].loan_int_rate);
    $("#loan_bal0" + i).text(toMoney(loanWithInterest));
  }
  int = loanWithInterest - totalAmt;
  $(`#loan_int_accrued`).text(toMoney(int)); //show the interest
}; // end: function updateForm()

// ----- ANGULAR -----
//creates variable app and assign value angular module
var app = angular.module("myApp", []);

//contoller takes the total amount borrowed and spread it in how many years
app.controller("myCtrl", function ($scope) {
  $scope.payments = []; // controller connects with the view in HTML
  $scope.populate = function () {
    //populates the payments array

    updateForm(); //updates form

    //payments
    let total = loanWithInterest; //calculate total
    let iRate = loans[0].loan_int_rate;
    let r = iRate / 12;
    let n = 11;
    //loan payment formula
    //https://www.thebalance.com/loan-payment-calculations-315564
    let pay =
      12 * (total / (((1 + r) ** (n * 12) - 1) / (r * (1 + r) ** (n * 12)))); //formula to get computation with same payments for every period
    for (let i = 0; i < 10; i++) {
      //loop that generate the calculation as the period increases
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
