package com.sunshine.weather.current;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.List;

@Configuration
class CurrentWeatherConfiguration {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder
                .setConnectTimeout(Duration.ofMinutes(2))
                .setReadTimeout(Duration.ofMinutes(2))
                .build();
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
