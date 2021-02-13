package com.sunshine.weather.providers;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
enum WeatherProvider {
    OPEN_WEATHER("OpenWeather"),
    WEATHERBIT("Weatherbit"),
    ACCU_WEATHER("AccuWeather");

    private final String name;
}
