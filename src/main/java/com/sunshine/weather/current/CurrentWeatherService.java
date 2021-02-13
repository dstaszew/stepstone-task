package com.sunshine.weather.current;

import java.util.List;
import java.util.stream.Collectors;

class CurrentWeatherService {

    private final List<CurrentWeatherProvider> weatherProviders;

    CurrentWeatherService(List<CurrentWeatherProvider> weatherProviders) {
        this.weatherProviders = weatherProviders;
    }

    List<CurrentWeatherDto> getAllFor(String cityName) {
        return weatherProviders.stream()
                .map(p -> p.getFor(cityName))
                .collect(Collectors.toList());
    }

    CurrentWeatherDto getForCityNameBy(String cityName, String provider) {
         return weatherProviders.stream()
                 .filter(p -> p.name().equals(provider))
                 .findAny()
                 .map(p -> p.getFor(cityName))
                 .orElseThrow(() -> new WeatherProviderNotFoundException("Provider: " + provider + " has not been found"));
    }
}
