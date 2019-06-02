package com.openweather.demo.service;

import com.openweather.demo.domain.OpenWeatherResult;

/**
 * Weather Service Interface
 */
public interface WeatherService {

	/**
	 * get weather by city
	 * @param city the city name
	 * @return the OpenWeatherResult
	 */
	OpenWeatherResult getWeather(String city);

}
