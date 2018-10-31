package com.flight_management_system.business_logic.utils;

import java.sql.Date;

import org.json.JSONObject;

public class FlightFilter {

	private String departureCountry;
	private String departureCity;
	private String arrivalCountry;
	private String arrivalCity;
	private Date departureStartDate;
	private Date departureEndDate;

	public FlightFilter() {
		super();
	}

	public FlightFilter(String departureCountry, String departureCity, String arrivalCountry, String arrivalCity, Date departureStartDate, Date departureEndDate) {
		super();
		this.departureCountry = departureCountry;
		this.departureCity = departureCity;
		this.arrivalCountry = arrivalCountry;
		this.arrivalCity = arrivalCity;
		this.departureStartDate = departureStartDate;
		this.departureEndDate = departureEndDate;
	}

	public static FlightFilter fromJSONObject(JSONObject flightFilterJSON) {
		FlightFilter flightFilter = new FlightFilter();
		flightFilter.setDepartureCity(flightFilterJSON.getString("departure_city"));
		flightFilter.setArrivalCity(flightFilterJSON.getString("arrival_city"));
		if (flightFilterJSON.getString("departure_date_start") != null
				&& !flightFilterJSON.getString("departure_date_start").isEmpty()) {
			flightFilter.setDepartureStartDate(Date.valueOf(flightFilterJSON.getString("departure_date_start")));
		}
		if (flightFilterJSON.getString("departure_date_end") != null
				&& !flightFilterJSON.getString("departure_date_end").isEmpty()) {
			flightFilter.setDepartureEndDate(Date.valueOf(flightFilterJSON.getString("departure_date_end")));
		}
		return flightFilter;
	}

	public String getDepartureCountry() {
		return departureCountry;
	}

	public void setDepartureCountry(String departureCountry) {
		this.departureCountry = departureCountry;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getArrivalCountry() {
		return arrivalCountry;
	}

	public void setArrivalCountry(String arrivalCountry) {
		this.arrivalCountry = arrivalCountry;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public Date getDepartureStartDate() {
		return departureStartDate;
	}

	public void setDepartureStartDate(Date departureStartDate) {
		this.departureStartDate = departureStartDate;
	}

	public Date getDepartureEndDate() {
		return departureEndDate;
	}

	public void setDepartureEndDate(Date departureEndDate) {
		this.departureEndDate = departureEndDate;
	}
}
