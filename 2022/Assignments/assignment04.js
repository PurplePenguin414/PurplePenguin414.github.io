//form code

document
  .getElementById("loadjson")
  .addEventListener("click", loadJson);
document
  .getElementById("loadpriorcountry")
  .addEventListener("click", loadPriorCountry);
document
  .getElementById("loadnextcountry")
  .addEventListener("click", loadNextCountry);

let country = 0
let json
function loadJson() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange 
    = function() {
        if (this.readyState == 4 && this.status == 200) {
          document.getElementById("coviddata").innerHTML 
            = "JSON data loaded.";
          json = JSON.parse(this.responseText);
        }
      };
  xhttp.open("GET", "https://api.covid19api.com/summary", true);
  xhttp.send();
}

let id = document.getElementById("id");
let c = document.getElementById("Country");
let code = document.getElementById("Code");
let slug = document.getElementById("Slug");
let ncon = document.getElementById("nConfirmed");
let tcon = document.getElementById("tConfirmed");
let ndeath = document.getElementById("nDeaths");
let tdeath = document.getElementById("tDeaths");
let nrec = document.getElementById("nRecovered");
let trec =document.getElementById("tRecovered");
let d = document.getElementById("date");

function loadPriorCountry () {
  country--
  if (country < 0) {
    country = 0
    id.innerHTML = json.Countries[country].ID
    c.innerHTML = json.Countries[country].Country
    code.innerHTML = json.Countries[country].CountryCode
    slug.innerHTML = json.Countries[country].Slug
    ncon.innerHTML = json.Countries[country].NewConfirmed
    tcon.innerHTML = json.Countries[country].TotalConfirmed
    ndeath.innerHTML = json.Countries[country].NewDeaths
    tdeath.innerHTML = json.Countries[country].TotalDeaths
    nrec.innerHTML = json.Countries[country].NewRecovered
    trec.innerHTML = json.Countries[country].TotalRecovered
    d.innerHTML = json.Countries[country].Date
  }
    
}
function loadNextCountry () {
  country++
  if (country > json.Countries.length - 1) {
    country = json.Countries.length - 1
    id.innerHTML = json.Countries[country].ID
    c.innerHTML = json.Countries[country].Country
    code.innerHTML = json.Countries[country].CountryCode
    slug.innerHTML = json.Countries[country].Slug
    ncon.innerHTML = json.Countries[country].NewConfirmed
    tcon.innerHTML = json.Countries[country].TotalConfirmed
    ndeath.innerHTML = json.Countries[country].NewDeaths
    tdeath.innerHTML = json.Countries[country].TotalDeaths
    nrec.innerHTML = json.Countries[country].NewRecovered
    trec.innerHTML = json.Countries[country].TotalRecovered
    d.innerHTML = json.Countries[country].Date
  }
}
