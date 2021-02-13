package com.sunshine.weather.current;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
class CurrentWeatherConfiguration {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    List<CurrentWeatherProvider> weatherProviders(RestTemplate restTemplate) {
        return List.of(
                new OpenWeatherProvider(restTemplate),
                new WeatherbitProvider(restTemplate),
                new AccuWeatherProvider(restTemplate)
        );
    }

    @Bean
    CurrentWeatherService currentWeatherService(List<CurrentWeatherProvider> weatherProviders) {
        return new CurrentWeatherService(weatherProviders);
    }

}
