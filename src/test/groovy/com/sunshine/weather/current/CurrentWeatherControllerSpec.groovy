package com.sunshine.weather.current

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.hamcrest.Matchers.hasSize
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class CurrentWeatherControllerSpec extends Specification {

    @Autowired
    protected MockMvc mvc

    def "check if current weather has been fetched for all providers"() {
        when:
        def results = mvc.perform(get('/api/v1/weather/Warsaw/current/'))

        then:
        results.andExpect(status().isOk())
        results.andExpect(jsonPath('$', hasSize(3)))
    }

    def "check if current weather has been fetched for specified provider"() {
        when:
        def results = mvc.perform(get('/api/v1/weather/Warsaw/current/OpenWeather'))

        then:
        results.andExpect(status().isOk())
    }

}
