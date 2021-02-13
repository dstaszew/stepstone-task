package com.sunshine.weather.current;

class WeatherProviderNotFoundException extends RuntimeException {

    WeatherProviderNotFoundException(String message) {
        super(message);
    }
}
