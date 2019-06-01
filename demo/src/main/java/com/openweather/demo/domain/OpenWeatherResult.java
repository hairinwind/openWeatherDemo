package com.openweather.demo.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherResult {
	private String name;
	private List<Weather> weather;
	private Main main;
	private Sys sys;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Weather> getWeather() {
		return weather;
	}
	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}
	public Main getMain() {
		return main;
	}
	public void setMain(Main main) {
		this.main = main;
	}
	public Sys getSys() {
		return sys;
	}
	public void setSys(Sys sys) {
		this.sys = sys;
	}
	@Override
	public String toString() {
		return "OpenWeatherResult [name=" + name + ", weather=" + weather + ", main=" + main + ", sys=" + sys + "]";
	}
	
}
