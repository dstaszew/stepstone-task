package com.sunshine.weather.current;

import lombok.Value;

@Value
class CurrentWeatherDto {

    String provider;
    Double windSpeed;
    Double windDirection;
    Double temperature;
    Double apparentTemperature;
    String weather;  //eg Clouds, Clear etc

    Double humidity;


    Double pressure;
    //TODO add any additional necessary property

}
