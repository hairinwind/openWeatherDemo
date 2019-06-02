package com.openweather.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *This is the POJO to represent Sys section in the json returned from OpenWeather 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sys {
	private long sunrise;
	private long sunset;
	
	public long getSunrise() {
		return sunrise;
	}

	public void setSunrise(long sunrise) {
		this.sunrise = sunrise;
	}

	public long getSunset() {
		return sunset;
	}

	public void setSunset(long sunset) {
		this.sunset = sunset;
	}

	@Override
	public String toString() {
		return "Sys [sunrise=" + sunrise + ", sunset=" + sunset + "]";
	}
	
}
