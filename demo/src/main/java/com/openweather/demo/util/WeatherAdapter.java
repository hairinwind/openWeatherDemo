package com.openweather.demo.util;

import java.time.LocalDate;

import org.springframework.util.CollectionUtils;

import com.openweather.demo.domain.OpenWeatherResult;
import com.openweather.demo.model.Weather;

/**
 * This is the adapter class between OpenWeatherResult and the model Weather
 */
public class WeatherAdapter {

	/**
	 * This is the method which adapt OpenWeatherResult to the model Weather
	 * @param openWeatherResult the openWeatherResult object
	 * @return the model Weather
	 */
	public static Weather adaptToWeather(OpenWeatherResult openWeatherResult) {
		Weather weather = new Weather();
		weather.setDate(LocalDate.now());
		weather.setCity(openWeatherResult.getName());
		if (!CollectionUtils.isEmpty(openWeatherResult.getWeather())){
			weather.setDescription(openWeatherResult.getWeather().get(0).getDescription());
		}
		weather.setTemprature(openWeatherResult.getMain().getTemp());
		
		//The sunrise and sunset are long values of seconds, convert them to milliseconds 
		weather.setSunriseTime(openWeatherResult.getSys().getSunrise() * 1000L);
		weather.setSunsetTime(openWeatherResult.getSys().getSunset() * 1000L);
		
		return weather;
	}

}
