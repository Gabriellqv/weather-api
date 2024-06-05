package com.example.weatherapi.controller;

import com.example.weatherapi.model.Weather;
import com.example.weatherapi.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/current")
    public Weather getCurrentWeather(@RequestParam String city) {
        Weather weather = weatherService.getCurrentWeather(city);
        if (weather == null) {
            weather = weatherService.fetchWeatherFromApi(city);
            // Opcional: salvar no banco de dados local
            // weatherRepository.save(weather);
        }
        return weather;
    }
}
