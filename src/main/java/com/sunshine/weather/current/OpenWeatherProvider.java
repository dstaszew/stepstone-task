package com.sunshine.weather.current;

import org.springframework.web.client.RestTemplate;

import java.util.Objects;

class OpenWeatherProvider implements CurrentWeatherProvider {

    private final RestTemplate restTemplate;

    private final String apiKey;

    OpenWeatherProvider(RestTemplate restTemplate, String apiKey) {
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
    }

    @Override
    public String name() {
        return "OpenWeather";
    }

    @Override
    public CurrentWeatherDto getFor(String cityName) {
        final String uri = "http://api.openweathermap.org/data/2.5/weather?q={cityName}&appid={APIkey}&units=metric";
        OpenWeatherActualDto responseDto = restTemplate.getForObject(uri, OpenWeatherActualDto.class, cityName, apiKey);
        return mapToCurrentWeatherDto(Objects.requireNonNull(responseDto));
    }

    private CurrentWeatherDto mapToCurrentWeatherDto(OpenWeatherActualDto openWeatherActualDto) {
        return new CurrentWeatherDto(
                name(),
                openWeatherActualDto.getWindSpeed(),
                openWeatherActualDto.getWindDirection(),
                openWeatherActualDto.getTemp(),
                openWeatherActualDto.getFeelsLikeTemp(),
                openWeatherActualDto.getWeather(),
                openWeatherActualDto.getHumidity(),
                openWeatherActualDto.getPressure()
                );

    }
}
