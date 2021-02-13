package com.sunshine.weather.current;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/weather")
class CurrentWeatherController {

    private final CurrentWeatherService currentWeatherService;

    CurrentWeatherController(CurrentWeatherService currentWeatherService) {
        this.currentWeatherService = currentWeatherService;
    }

    @GetMapping("/{cityName}/current")
    public List<CurrentWeatherDto> currentWeather(@PathVariable String cityName) {
        return currentWeatherService.getAllFor(cityName);
    }

    @GetMapping("/{cityName}/current/{provider}")
    public CurrentWeatherDto currentWeatherDependOnProvider(@PathVariable String cityName, @PathVariable String provider) {
        return currentWeatherService.getForCityNameBy(cityName, provider);
    }

}
