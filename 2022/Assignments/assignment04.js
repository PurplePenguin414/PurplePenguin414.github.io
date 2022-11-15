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

function loadPriorCountry () {
  country--
  if (country < 0) 
    country = 0
    id.innerHTML = json.Countries[country].ID
    document.getElementById("Country").innerHTML 
    = json.Countries[country].Country
    document.getElementById("Code").innerHTML 
    = json.Countries[country].CountryCode
    document.getElementById("Slug").innerHTML 
    = json.Countries[country].Slug
    document.getElementById("nConfirmed").innerHTML 
    = json.Countries[country].NewConfirmed
    document.getElementById("tConfirmed").innerHTML 
    = json.Countries[country].TotalConfirmed
    document.getElementById("nDeaths").innerHTML 
    = json.Countries[country].NewDeaths
    document.getElementById("tDeaths").innerHTML 
    = json.Countries[country].TotalDeaths
    document.getElementById("nRecovered").innerHTML 
    = json.Countries[country].NewRecovered
    document.getElementById("tRecovered").innerHTML 
    = json.Countries[country].TotalRecovered
    document.getElementById("date").innerHTML 
    = json.Countries[country].Date
    
}
function loadNextCountry () {
  country++
  if (country > json.Countries.length - 1) 
    country = json.Countries.length - 1;
    document.getElementById("id").innerHTML 
    = json.Countries[country].ID
    document.getElementById("Country").innerHTML 
    = json.Countries[country].Country
    document.getElementById("Code").innerHTML 
    = json.Countries[country].CountryCode
    document.getElementById("Slug").innerHTML 
    = json.Countries[country].Slug
    document.getElementById("nConfirmed").innerHTML 
    = json.Countries[country].NewConfirmed
    document.getElementById("tConfirmed").innerHTML 
    = json.Countries[country].TotalConfirmed
    document.getElementById("nDeaths").innerHTML 
    = json.Countries[country].NewDeaths
    document.getElementById("tDeaths").innerHTML 
    = json.Countries[country].TotalDeaths
    document.getElementById("nRecovered").innerHTML 
    = json.Countries[country].NewRecovered
    document.getElementById("tRecovered").innerHTML 
    = json.Countries[country].TotalRecovered
    document.getElementById("date").innerHTML 
    = json.Countries[country].Date
}
