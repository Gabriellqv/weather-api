package com.example.weatherapi.service;

import com.example.weatherapi.model.Weather;
import com.example.weatherapi.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    @Autowired
    private WeatherRepository weatherRepository;

    public Weather getCurrentWeather(String city) {
        // Primeiro, tentamos obter os dados do banco de dados
        Weather weather = weatherRepository.findByCity(city);

        // Se não houver dados no banco de dados para a cidade especificada,
        // simulamos os dados meteorológicos
        if (weather == null) {
            weather = fetchWeatherFromApi(city);
            // Salvar os dados simulados no banco de dados para uso futuro
            weatherRepository.save(weather);
        }

        return weather;
    }

    // Simular chamada a uma API externa de clima
    public Weather fetchWeatherFromApi(String city) {
        Weather weather = new Weather();
        weather.setCity(city);
        // Simulando valores fixos para descrição, temperatura, umidade e velocidade do vento
        weather.setDescription("Clear sky");
        weather.setTemperature(25.0);
        weather.setHumidity(40.0);
        weather.setWindSpeed(10.0);
        return weather;
    }
}
