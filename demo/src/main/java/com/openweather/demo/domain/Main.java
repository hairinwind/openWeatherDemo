package com.openweather.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *This is the POJO to represent Main section in the json returned from OpenWeather 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Main {
	private double temp;

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	@Override
	public String toString() {
		return "Main [temp=" + temp + "]";
	}
	
}
