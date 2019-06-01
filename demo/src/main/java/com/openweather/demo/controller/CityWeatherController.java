package com.openweather.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.openweather.demo.domain.OpenWeatherResult;
import com.openweather.demo.model.City;
import com.openweather.demo.model.Weather;
import com.openweather.demo.service.WeatherService;
import com.openweather.demo.util.WeatherAdapter;

@Controller
public class CityWeatherController {
	
	@Autowired
	private WeatherService weatherService;
	
	@RequestMapping("/")
	protected String index(Model model){
		City city = new City();
		model.addAttribute("city", city);
		return "weather";
	}

	@RequestMapping("/cityweather")
	protected String getWeatherByCity(@ModelAttribute(value="city") City city, Model model){
		OpenWeatherResult openWeatherResult = weatherService.getWeather(city.getName());
		
		Weather weather = WeatherAdapter.adaptToWeather(openWeatherResult);
		model.addAttribute("weather", weather);
		return "weather";
	}
}
