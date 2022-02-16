package com.example.juniorspring.apicrud.services;

import com.example.juniorspring.apicrud.entities.CarEntity;
import com.example.juniorspring.apicrud.entities.CarImage;
import com.example.juniorspring.apicrud.repositories.CarImageRepository;
import com.example.juniorspring.apicrud.repositories.CarRepository;
import com.example.juniorspring.apicrud.wrappers.CarImageWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    CarImageRepository carImageRepository;

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

    @Override
    public CarImage upload(CarImageWrapper ciw) {
        CarImage carImage = new CarImage();
        carImage.setCar(carRepository.findById(ciw.getCarId()).get());
        carImage.setKontenType(ciw.getKontenType());
        carImage.setBase64(ciw.getBase64());
        return carImageRepository.save(carImage);
    }

}
