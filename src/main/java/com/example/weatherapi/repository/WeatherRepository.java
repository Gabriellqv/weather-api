package com.example.weatherapi.repository;

import com.example.weatherapi.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<Weather, Long> {
    Weather findByCity(String city);
}
