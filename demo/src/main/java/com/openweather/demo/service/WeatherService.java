package com.openweather.demo.service;

import com.openweather.demo.domain.OpenWeatherResult;

public interface WeatherService {

	OpenWeatherResult getWeather(String city);

}
