package com.sunshine.weather.current;

import org.springframework.web.client.RestTemplate;

class AccuWeatherProvider implements CurrentWeatherProvider {

    private final RestTemplate restTemplate;

    AccuWeatherProvider(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String name() {
        return "AccuWeather";
    }

    @Override
    public CurrentWeatherDto getFor(String cityName) {
        return null;
    }
}
