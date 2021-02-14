package com.sunshine.weather.current;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.stream.Collectors;

@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class OpenWeatherActualDto {

    @NonNull
    List<WeatherDto> weather;
    @NonNull
    MainDto main;
    @NonNull
    WindDto wind;

    @Value
    @NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
    @AllArgsConstructor
    private static class WeatherDto {
        String main;
    }

    @Value
    @NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
    @AllArgsConstructor
    private static class MainDto {
        Double temp;
        @JsonProperty("feels_like")
        Double feelsLikeTemp;
        Double pressure;
        Double humidity;
    }

    @Value
    @NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
    @AllArgsConstructor
    private static class WindDto {
        Double speed;
        Double deg;
    }

    public Double getTemp() {
        return main.getTemp();
    }

    public Double getFeelsLikeTemp() {
        return main.getFeelsLikeTemp();
    }

    public Double getPressure() {
        return main.getPressure();
    }

    public Double getHumidity() {
        return main.getHumidity();
    }

    public String getWeather() {
        return weather.stream().map(WeatherDto::getMain).collect(Collectors.joining());
    }

    public Double getWindSpeed() {
        return wind.getSpeed();
    }

    public Double getWindDirection() {
        return wind.getDeg();
    }

}
