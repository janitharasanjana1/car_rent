package com.janitha.megacity.service.impl;

import com.janitha.megacity.dao.CarDAO;
import com.janitha.megacity.dto.CarDTO;
import com.janitha.megacity.entity.Car;
import com.janitha.megacity.service.CarService;

import java.util.List;

public class CarServiceImpl implements CarService {
    private CarDAO carDAO = new CarDAO();
    @Override
    public void addCar(CarDTO carDTO) {
        // Convert DTO to Entity (Car)
        Car car = new Car();
        car.setName(carDTO.getName());
        car.setModel(carDTO.getModel());
        car.setPlate_number(carDTO.getPlate_number());
        car.setYear(carDTO.getYear());
        car.setStatus(carDTO.getStatus());

        // Persist car in the database
        carDAO.addCar(car);
    }

    @Override
    public CarDTO getCarById(int id) {
        Car car = carDAO.getCarById(id);
        if (car != null) {
            return new CarDTO(car.getId(), car.getName(), car.getModel(), car.getPlate_number(), car.getYear(), car.getStatus());
        }
        return null;
    }

    @Override
    public List<CarDTO> getAllCars() {
        List<Car> cars = carDAO.getAllCars();
        return cars.stream()
                .map(car -> new CarDTO(car.getId(), car.getName(), car.getModel(), car.getPlate_number(), car.getYear(), car.getStatus()))
                .toList();
    }

    @Override
    public void updateCar(CarDTO carDTO) {
        // Convert DTO to Entity (Car)
        Car car = new Car();
        car.setId(carDTO.getId());
        car.setName(carDTO.getName());
        car.setModel(carDTO.getModel());
        car.getPlate_number();
        car.setYear(carDTO.getYear());
        car.setStatus(carDTO.getStatus());

        // Update car in the database
        carDAO.updateCar(car);
    }

    @Override
    public void deleteCar(int id) {
        carDAO.deleteCar(id);
    }





}
