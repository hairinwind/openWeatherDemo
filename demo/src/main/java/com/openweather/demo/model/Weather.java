package com.openweather.demo.model;

import java.time.LocalDate;

import com.openweather.demo.util.DateUtil;
import com.openweather.demo.util.TemperatureUtil;

/**
 *This is the Model class of Weather 
 */
public class Weather {
	private String city;
	private LocalDate date;
	private String description;
	private double temprature;
	private long sunriseTime; //long value in milliseconds
	private long sunsetTime; //long value in milliseconds
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getTemprature() {
		return temprature;
	}
	public void setTemprature(double temprature) {
		this.temprature = temprature;
	}
	public long getSunriseTime() {
		return sunriseTime;
	}
	public void setSunriseTime(long sunriseTime) {
		this.sunriseTime = sunriseTime;
	}
	public long getSunsetTime() {
		return sunsetTime;
	}
	public void setSunsetTime(long sunsetTime) {
		this.sunsetTime = sunsetTime;
	}
	
	public long getCelsius() {
		return TemperatureUtil.convertKelvinToCelsius(this.temprature);
	}
	
	public long getFahrenheit() {
		return TemperatureUtil.convertKelvinToFahrenheit(this.temprature);
	}
	
	public String getSunriseFormatted() {
		return DateUtil.getFormattedTime(this.sunriseTime, this.city);
	}
	
	public String getSunsetFormatted() {
		return DateUtil.getFormattedTime(this.sunsetTime, this.city);
	}

}
