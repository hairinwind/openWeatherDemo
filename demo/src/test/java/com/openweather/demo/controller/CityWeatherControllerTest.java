package com.openweather.demo.controller;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.openweather.demo.domain.Main;
import com.openweather.demo.domain.OpenWeatherResult;
import com.openweather.demo.domain.Sys;
import com.openweather.demo.domain.Weather;
import com.openweather.demo.model.City;
import com.openweather.demo.service.WeatherService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = CityWeatherController.class)
public class CityWeatherControllerTest {

	@MockBean
	private WeatherService weatherService;

	@Autowired
    private MockMvc mockMvc;

	@Test
    public void main() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("weather"))
                .andExpect(model().attribute("city", equalTo(new City())));
    }
	
	@Test
    public void TestGetWeatherByCity() throws Exception {
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
		
		String cityName = "london,uk";
		given(this.weatherService.getWeather(cityName)).willReturn(mockOpenWeatherResult);
		City london = new City(cityName);
        ResultActions resultActions = mockMvc.perform(post("/cityweather")
        		.contentType(MediaType.APPLICATION_FORM_URLENCODED)
        		.param("name", cityName)
        		)
                .andExpect(status().isOk())
                .andExpect(view().name("weather"))
                .andExpect(model().attribute("city", equalTo(london)))
                .andExpect(model().attribute("weather", instanceOf(com.openweather.demo.model.Weather.class)));
    }
}
