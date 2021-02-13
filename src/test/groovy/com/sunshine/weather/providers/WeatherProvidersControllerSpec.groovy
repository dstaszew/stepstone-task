package com.sunshine.weather.providers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import static org.hamcrest.Matchers.*
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import spock.lang.Specification

@SpringBootTest
@AutoConfigureMockMvc
class WeatherProvidersControllerSpec extends Specification {

    @Autowired
    protected MockMvc mvc

    def "check if all list of providers have been fetched"() {
        when:
        def results = mvc.perform(get('/api/v1/weather/providers'))

        then:
        results.andExpect(status().isOk())

        and:
        results.andExpect(jsonPath('$', hasSize(3)))
        results.andExpect(jsonPath('$.[0]', is("OpenWeather")))
        results.andExpect(jsonPath('$.[1]', is("Weatherbit")))
        results.andExpect(jsonPath('$.[2]', is("AccuWeather")))
    }
}
