package com.openweather.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.openweather.demo.domain.OpenWeatherResult;

@Service
public class WeatherServiceImpl implements WeatherService {
	
	@Value("${appId}")
	private String appId;

	@Value("${openWeatherApiUrl}")
	private String openWeatherApiUrl;
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	@Autowired
    private RestTemplate restTemplate;
	
	@Override
	public OpenWeatherResult getWeather(String city) {
		String url = buildOpenWeatherUrl(city);
		OpenWeatherResult openWeatherResult = restTemplate.getForObject(url, OpenWeatherResult.class);
		return openWeatherResult;
	}
	
	private String buildOpenWeatherUrl(String city) {
		return openWeatherApiUrl + "?q=" + city + "&APPID=" + appId;
	}
}
