# OpenWeatherMap sample project

## what is implemented
- a spring boot project
- MVC and Thymeleaf to do the UI
- Controller and Service
- Pojo domain objects to represent the result from openWeatherMap
- an adapter to convert domain objects to model
- some util classes to do the date format or temprature converting
- a generic error message, although it is not used here. I can explain more if you are interested in error handling.
- java doc
- unit test were implemented
- appId and openWeatherApiUrl were put in application.properties

## How to run it 
- git clone https://github.com/hairinwind/openWeatherDemo.git
- cd openWeatherDemo
- cd demo
- mvn package
- java -jar target/demo-0.0.1-SNAPSHOT.jar

## any questions?
Please contact dong_yao@hotmail.com