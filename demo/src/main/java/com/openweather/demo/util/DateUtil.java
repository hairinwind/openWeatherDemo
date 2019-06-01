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

public class DateUtil {
	public static String getFormattedTime(long datelong, String city) {
		Date date = new Date(datelong * 1000L); // convert to millisecond
		Instant instant = date.toInstant();
		ZoneId timezoneId = getTimezoneByCity(city);
		ZonedDateTime zonedDatetime = instant.atZone(timezoneId);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mma");
		return zonedDatetime.format(formatter);
	}
	
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
