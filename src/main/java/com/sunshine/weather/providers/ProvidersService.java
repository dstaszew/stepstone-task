package com.sunshine.weather.providers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class ProvidersService {

    public List<String> getAll() {
        return Arrays.stream(WeatherProvider.values())
                .map(WeatherProvider::getName)
                .collect(Collectors.toList());
    }
}
