package com.openweather.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.openweather.demo.domain.OpenWeatherResult;

@Service
public class WeatherServiceImpl implements WeatherService {
	
	@Value("${appId}")
	private String appId;
	
	@Value("${openWeatherApiUrl}")
	private String openWeatherApiUrl;
	
	@Override
	public OpenWeatherResult getWeather(String city) {
		RestTemplate restTemplate = new RestTemplate();
		String url = buildOpenWeatherUrl(city);
		OpenWeatherResult openWeatherResult = restTemplate.getForObject(url, OpenWeatherResult.class);
		return openWeatherResult;
	}
	
	private String buildOpenWeatherUrl(String city) {
		return openWeatherApiUrl + "?q=" + city + "&APPID=" + appId;
	}
}
