package com.openweather.demo.util;

public class TemperatureUtil {
	public static long convertKelvinToCelsius(double kelvin) {
		return Math.round(kelvin - 273.15);
	}
	
	public static long convertKelvinToFahrenheit(double kelvin) {
		return Math.round((kelvin - 273.15) * 9/5 + 32);
	}
}
