package com.openweather.demo.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class TemperatureUtilTest {

	@Test
	public void testConvertKelvinToCelsius() {
		assertEquals(27, TemperatureUtil.convertKelvinToCelsius(300));
	}

	@Test
	public void testConvertKelvinToFahrenheit() {
		assertEquals(80, TemperatureUtil.convertKelvinToFahrenheit(300));
	}

}
