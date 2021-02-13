package com.sunshine.weather.providers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/weather")
class WeatherProvidersController {

    private final ProvidersService providersService;

    WeatherProvidersController(ProvidersService providersService) {
        this.providersService = providersService;
    }

    @GetMapping("/providers")
    public List<String> providers() {
        return providersService.getAll();
    }
}
