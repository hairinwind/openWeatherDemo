package com.openweather.demo.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DateUtilTest {

	@Test
	public void testGetFormattedTime() {
		assertEquals(DateUtil.getFormattedTime(1559274618000L, "london"), "04:50AM");
		assertEquals(DateUtil.getFormattedTime(1559333181000L, "london"), "09:06PM");
		assertEquals(DateUtil.getFormattedTime(1559338756000L, "hong kong"), "05:39AM");
		assertEquals(DateUtil.getFormattedTime(1559386995000L, "hong kong"), "07:03PM");
	}

}
