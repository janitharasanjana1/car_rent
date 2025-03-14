package com.janitha.megacity.service;
import com.janitha.megacity.dto.CarDTO;

import java.util.List;

public interface CarService {
    void addCar(CarDTO carDTO);
    CarDTO getCarById(int id);
    List<CarDTO> getAllCars();
    void updateCar(CarDTO carDTO);
    void deleteCar(int id);
}
