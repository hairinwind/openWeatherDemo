package com.openweather.demo.util;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.util.CollectionUtils;

/**
 * The Date related functions
 */
public class DateUtil {
	/**
	 * return the formatted time in 12 hour format by long value of date and the city
	 * @param dateLong the long value of the date in milliseconds
	 * @param city the city name
	 * @return the formatted time in 12 hour format, e.g 12:30pm
	 */
	public static String getFormattedTime(long dateLong, String city) {
		Date date = new Date(dateLong);
		Instant instant = date.toInstant();
		ZoneId timezoneId = getTimezoneByCity(city);
		if (timezoneId == null) {
			return null;
		}
		ZonedDateTime zonedDatetime = instant.atZone(timezoneId);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mma");
		return zonedDatetime.format(formatter);
	}
	
	/**
	 * get ZoneId by city
	 * @param city the city
	 * @return the ZoneId
	 */
	// TODO this function is assuming that it can find the timezone by the city name
	// if there are cities which timmezone cannot be find by the city name
	// we probably need a table to contain the mapping between city name and its timezone
	private static ZoneId getTimezoneByCity(String city) {
		String cityName = city.replace(" ", "_");
		final List<String> timeZones = Stream.of(TimeZone.getAvailableIDs())
		        .filter(zoneId -> zoneId.toLowerCase().contains(cityName.toLowerCase()))
		        .collect(Collectors.toList());
		if(!CollectionUtils.isEmpty(timeZones)) {
			String timezoneId = timeZones.get(0);
			return ZoneId.of(timezoneId);
		}
		return null;
	}
}
