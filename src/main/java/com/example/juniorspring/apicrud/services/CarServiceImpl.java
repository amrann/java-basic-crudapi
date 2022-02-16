package com.example.juniorspring.apicrud.services;

import com.example.juniorspring.apicrud.entities.CarEntity;
import com.example.juniorspring.apicrud.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Override
    public CarEntity tambahCar(CarEntity param) {
        return carRepository.save(param);
    }

    @Override
    public List<CarEntity> getAllData() {
        return carRepository.findAll();
    }

    @Override
    public CarEntity getCarById(int id) {
        return carRepository.findById(id).get();
    }

    @Override
    public CarEntity apdetCar(CarEntity param) {
        CarEntity findCar = carRepository.findById(param.getId()).get();
        findCar.setCarName(param.getCarName());
        findCar.setColor(param.getColor());
        findCar.setNumber(param.getNumber());
        findCar.setTipe(param.getTipe());
        return carRepository.save(findCar);
    }

    @Override
    public String hapusCar(int id) {
        carRepository.deleteById(id);
        return "Sukses delete Car id: "+id;
    }

}
