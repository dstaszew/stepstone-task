package com.sunshine.weather.current;

interface CurrentWeatherProvider {

    String name();

    CurrentWeatherDto getFor(String cityName);

}
