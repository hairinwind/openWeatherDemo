package com.openweather.demo.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.openweather.demo.domain.Main;
import com.openweather.demo.domain.OpenWeatherResult;
import com.openweather.demo.domain.Sys;
import com.openweather.demo.domain.Weather;

public class WeatherAdapterTest {

	@Test
	public void testAdaptToWeather() {
		OpenWeatherResult mockOpenWeatherResult = new OpenWeatherResult();
		mockOpenWeatherResult.setName("london");
		Main mockMain = new Main();
		mockMain.setTemp(280);
		mockOpenWeatherResult.setMain(mockMain);
		Sys mockSys = new Sys();
		mockSys.setSunrise(1559338756);
		mockSys.setSunset(1559386995);
		mockOpenWeatherResult.setSys(mockSys);
		List<Weather> mockWeathers = new ArrayList<Weather>();
		Weather weather = new Weather();
		weather.setDescription("weather description");
		mockWeathers.add(weather);
		mockOpenWeatherResult.setWeather(mockWeathers);
		
		com.openweather.demo.model.Weather weatherAdapted = WeatherAdapter.adaptToWeather(mockOpenWeatherResult);
		assertEquals("london", weatherAdapted.getCity());
		assertEquals(280.0, weatherAdapted.getTemprature(), 0);
		assertEquals(1559338756000L, weatherAdapted.getSunriseTime());
		assertEquals(1559386995000L, weatherAdapted.getSunsetTime());
		assertEquals("weather description", weatherAdapted.getDescription());
	}

}
