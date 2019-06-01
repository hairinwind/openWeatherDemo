package com.openweather.demo.util;

import java.time.LocalDate;

import org.springframework.util.CollectionUtils;

import com.openweather.demo.domain.OpenWeatherResult;
import com.openweather.demo.model.Weather;

public class WeatherAdapter {

	public static Weather adaptToWeather(OpenWeatherResult openWeatherResult) {
		Weather weather = new Weather();
		weather.setDate(LocalDate.now());
		weather.setCity(openWeatherResult.getName());
		if (!CollectionUtils.isEmpty(openWeatherResult.getWeather())){
			weather.setDescription(openWeatherResult.getWeather().get(0).getDescription());
		}
		weather.setTemprature(openWeatherResult.getMain().getTemp());
		weather.setSunriseTime(openWeatherResult.getSys().getSunrise());
		weather.setSunsetTime(openWeatherResult.getSys().getSunset());
		return weather;
	}

}
