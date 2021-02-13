package com.sunshine.weather.current;

import org.springframework.web.client.RestTemplate;

public class WeatherbitProvider implements CurrentWeatherProvider {

    private final RestTemplate restTemplate;

    public WeatherbitProvider(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String name() {
        return "Weatherbit";
    }

    @Override
    public CurrentWeatherDto getFor(String cityName) {
        return null;
    }
}
