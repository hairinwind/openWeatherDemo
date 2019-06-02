package com.openweather.demo.util;

/**
 * The temperature related function
 */
public class TemperatureUtil {
	/**
	 * Convert kelvin to celsius
	 * @param kelvin the value of kelvin
	 * @return the value of celsius
	 */
	public static long convertKelvinToCelsius(double kelvin) {
		return Math.round(kelvin - 273.15);
	}
	
	/**
	 * Convert kelvin to fahrenheit
	 * @param kelvin the value of kelvin
	 * @return the value of fahrenheit
	 */
	public static long convertKelvinToFahrenheit(double kelvin) {
		return Math.round((kelvin - 273.15) * 9/5 + 32);
	}
}
