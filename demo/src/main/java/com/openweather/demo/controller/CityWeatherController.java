package com.openweather.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.openweather.demo.domain.OpenWeatherResult;
import com.openweather.demo.model.City;
import com.openweather.demo.model.Weather;
import com.openweather.demo.service.WeatherService;
import com.openweather.demo.util.WeatherAdapter;

@Controller
public class CityWeatherController {
	
	// this is for demo purpose only
	// ideally these data shall be saved in database
	private static List<City> allCities = new ArrayList<City>();
	static {
		allCities.add(new City("london,uk"));
		allCities.add(new City("hong kong,cn"));
	}
	
	@Autowired
	private WeatherService weatherService;
	
	@GetMapping("/")
	protected String index(Model model){
		City city = new City();
		model.addAttribute("city", city);
		model.addAttribute("allCities", allCities);
		return "weather";
	}

	@RequestMapping("/cityweather")
	protected String getWeatherByCity(@ModelAttribute(value="city") City city, Model model){
		model.addAttribute("allCities", allCities);
		if (city.getName() != null) {
			OpenWeatherResult openWeatherResult = weatherService.getWeather(city.getName());		
			Weather weather = WeatherAdapter.adaptToWeather(openWeatherResult);
			model.addAttribute("weather", weather);
		}
		return "weather";
	}
}
