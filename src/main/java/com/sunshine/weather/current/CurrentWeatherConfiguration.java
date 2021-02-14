package com.sunshine.weather.current;

import org.springframework.beans.factory.annotation.Value;
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
    List<CurrentWeatherProvider> weatherProviders(RestTemplate restTemplate,
                                                  @Value("${openweather.apikey}")String openWeatherApiKey) {
        return List.of(
                new OpenWeatherProvider(restTemplate, openWeatherApiKey),
                new WeatherbitProvider(restTemplate),
                new AccuWeatherProvider(restTemplate)
        );
    }

    @Bean
    CurrentWeatherService currentWeatherService(List<CurrentWeatherProvider> weatherProviders) {
        return new CurrentWeatherService(weatherProviders);
    }

}
