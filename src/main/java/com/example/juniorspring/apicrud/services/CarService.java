package com.example.juniorspring.apicrud.services;

import com.example.juniorspring.apicrud.entities.CarEntity;
import com.example.juniorspring.apicrud.entities.CarImage;
import com.example.juniorspring.apicrud.wrappers.CarImageWrapper;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface CarService {
    CarEntity tambahCar(CarEntity param);

    List<CarEntity> getAllData();

    CarEntity getCarById(int id);

    CarEntity apdetCar(CarEntity param);

    String hapusCar(int id);

    CarImage upload(CarImageWrapper ciw);
}
