package com.example.juniorspring.apicrud.controllers;

import com.example.juniorspring.apicrud.entities.CarEntity;
import com.example.juniorspring.apicrud.repositories.CarRepository;
import com.example.juniorspring.apicrud.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="car")
public class CarCtrl {

    @Autowired
//    CarRepository carRepository;
    CarService carService;

//    // before package services
//    @PostMapping(value = "tambahNewCar")
//    public CarEntity addNewCar(@RequestBody CarEntity param) {
//        carRepository.save(param);
//        return param;
//    }
    @PostMapping(value = "tambahNewCar")
    public CarEntity addNewCar(@RequestBody CarEntity param) {
        CarEntity cr = carService.tambahCar(param);
        return cr;
    }

//    // before package services
//    @GetMapping(value = "getAllCar")
//    public List<CarEntity> getAllCar() {
//        return carRepository.findAll();
//    }
    @GetMapping(value = "getAllCar")
    public List<CarEntity> getAllCar() {
        List<CarEntity> carList = carService.getAllData();
        return carList;
    }

//    // before package services
//    @GetMapping(value = "getById")
//    public CarEntity getById(@RequestParam int id) {
//        return carRepository.findById(id).get();
//    }
    @GetMapping(value = "getById")
    public CarEntity getById(@RequestParam int id) {
        CarEntity carById = carService.getCarById(id);
        return carById;
    }

//    // before package services
//    @PostMapping(value = "apdetCar")
//    public CarEntity updateCar(@RequestBody CarEntity param) {
//        return carRepository.save(param);
//    }
    @PostMapping(value = "apdetCar")
    public CarEntity updateCar(@RequestBody CarEntity param) {
        CarEntity carApdet = carService.apdetCar(param);
        return carApdet;
    }

//    // before package service
//    @GetMapping(value = "deletCar")
//    public String deleteCar(@RequestParam int id) {
//        carRepository.deleteById(id);
//        return "Sukses delete Car id: "+id;
//    }
    @GetMapping(value = "deletCar")
    public String deleteCar(@RequestParam int id) {
        String carHapus = carService.hapusCar(id);
        return carHapus;
    }
}
