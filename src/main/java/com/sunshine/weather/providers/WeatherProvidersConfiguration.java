package com.sunshine.weather.providers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class WeatherProvidersConfiguration {

    @Bean
    ProvidersService providersService() {
        return new ProvidersService();
    }
}
