package com.openweather.demo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.openweather.demo.domain.Main;
import com.openweather.demo.domain.OpenWeatherResult;
import com.openweather.demo.domain.Sys;
import com.openweather.demo.domain.Weather;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:application.properties")
public class WeatherServiceImplTest {
	
	@TestConfiguration
	static class GavServiceImplTestContextConfiguration {
		
		@Bean
		public WeatherServiceImpl WeatherService() {
			return new WeatherServiceImpl();
		}
	}
	
	@MockBean
	private RestTemplate restTemplate;
	
	@Autowired
	private WeatherService weatherService;

	@Test
	public void testGetWeather() {
		OpenWeatherResult mockOpenWeatherResult = new OpenWeatherResult();
		mockOpenWeatherResult.setName("london");
		Main mockMain = new Main();
		mockMain.setTemp(280);
		mockOpenWeatherResult.setMain(mockMain );
		Sys mockSys = new Sys();
		mockSys.setSunrise(1559338756);
		mockSys.setSunset(1559386995);
		mockOpenWeatherResult.setSys(mockSys);
		List<Weather> mockWeathers = new ArrayList<Weather>();
		Weather weather = new Weather();
		weather.setDescription("weather description");
		mockWeathers.add(weather);
		mockOpenWeatherResult.setWeather(mockWeathers );
		
		String url = "http://api.openweathermap.org/data/2.5/weather?q=london&APPID=e9ff7e2159d2453e282d13950b869eb0";
		
		given(this.restTemplate.getForObject(url, OpenWeatherResult.class)).willReturn(mockOpenWeatherResult);
		OpenWeatherResult result = weatherService.getWeather("london");
		assertEquals(mockOpenWeatherResult, result);
	}

}
