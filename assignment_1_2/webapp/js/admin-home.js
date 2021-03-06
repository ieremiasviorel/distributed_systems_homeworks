var departure_country_select;
var departure_city_select;

var arrival_country_select;
var arrival_city_select;

var departure_date_start_select;
var departure_date_end_select;

var flights_table;

var flight_form;

$(document).ready(function() {
	
	departure_country_select = $("#departure_country");
	departure_country_select.on("change", () => 
		populateSelectWithCitiesByCountry(departure_country_select.val(), departure_city_select)
	);
	
	departure_city_select = $("#departure_city");
	
	arrival_country_select = $("#arrival_country");
	arrival_country_select.on("change", () => 
		populateSelectWithCitiesByCountry(arrival_country_select.val(), arrival_city_select)
	);
	
	arrival_city_select = $("#arrival_city");
	
	departure_date_start_select = $("#departure_date_start");
	departure_date_end_select = $("#departure_date_end");
	
	flight_form = $("#flight-form");
	//flight_form.hide();
});

function populateSelectWithCitiesByCountry(country, selectToPopulate) {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			selectToPopulate.empty();
			selectToPopulate.append($("<option selected hidden/>").val("").text("--"));
			citiesForCountry = this.responseText;
			$.each(JSON.parse(citiesForCountry), function() {
				selectToPopulate.append($("<option />").val(this).text(this));
			});
		}
	};
	xhr.open("GET", "cities?country=" + country, true);
	xhr.send();
}

function populateTableWithFlights() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			console.log(this.responseText);
		}
	};
	var data = {
			"departure_city": departure_city_select.val(),
			"arrival_city": arrival_city_select.val(),
			"departure_date_start": departure_date_start_select.val(),
			"departure_date_end": departure_date_end_select.val()
	};
	xhr.open("POST", "flights", true);
	xhr.send(JSON.stringify(data));
}

function selectFlight(flightNumber) {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var flight = JSON.parse(this.responseText);
			$("#form-flight-id").val(flight.id);
			$("#form-flight-number").val(flight.flightNumber);
			$("#form-airplane-type").val(flight.airplaneType);
			$("#form-departure-city").val(flight.departureCity.name);
			$("#form-departure-date").val(flight.departureDate);
			$("#form-departure-time").val(flight.departureTime);
			$("#form-arrival-city").val(flight.arrivalCity.name);
			$("#form-arrival-date").val(flight.arrivalDate);
			$("#form-arrival-time").val(flight.arrivalTime);
			flight_form.show();
		}
	};
	xhr.open("GET", "flights?flightNumber=" + flightNumber, true);
	xhr.send();
}