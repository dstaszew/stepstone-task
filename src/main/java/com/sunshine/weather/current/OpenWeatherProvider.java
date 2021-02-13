package com.sunshine.weather.current;

import org.springframework.web.client.RestTemplate;

class OpenWeatherProvider implements CurrentWeatherProvider {

    private final RestTemplate restTemplate;

    OpenWeatherProvider(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String name() {
        return "OpenWeather";
    }

    @Override
    public CurrentWeatherDto getFor(String cityName) {
        return null;
    }
}
