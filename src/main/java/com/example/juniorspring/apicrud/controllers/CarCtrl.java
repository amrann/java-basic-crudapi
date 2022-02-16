package com.example.juniorspring.apicrud.controllers;

import com.example.juniorspring.apicrud.entities.CarEntity;
import com.example.juniorspring.apicrud.repositories.CarRepository;
import com.example.juniorspring.apicrud.responses.CommonResponse;
import com.example.juniorspring.apicrud.responses.CommonResponseGenerator;
import com.example.juniorspring.apicrud.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="car")
public class CarCtrl {

    @Autowired
    CarService carService;

    @Autowired
    CommonResponseGenerator comResGen;

    @GetMapping(value="cekAPI")
    public CommonResponse<String> cekApi() {
        return comResGen.suksesResponse("Halo API", "Berhasil akses");
    }

    @PostMapping(value = "tambahNewCar")
    public CommonResponse<CarEntity> addNewCar(@RequestBody CarEntity param) {
        CarEntity cr = carService.tambahCar(param);
        return comResGen.suksesResponse(cr, "Berhasil menambah data");
    }

    @GetMapping(value = "getAllCar")
    public CommonResponse<List<CarEntity>> getAllCar() {
        List<CarEntity> carList = carService.getAllData();
        return comResGen.suksesResponse(carList, "Berhasil menampilkan semua data");
    }

    @GetMapping(value = "getById")
    public CommonResponse<CarEntity> getById(@RequestParam int id) {
        CarEntity carById = carService.getCarById(id);
        return comResGen.suksesResponse(carById, "Berhasil menampilkan data");
    }

    @PostMapping(value = "apdetCar")
    public CommonResponse<CarEntity> updateCar(@RequestBody CarEntity param) {
        CarEntity carApdet = carService.apdetCar(param);
        return comResGen.suksesResponse(carApdet, "Berhasil edit data");
    }

    @GetMapping(value = "deletCar")
    public CommonResponse<String> deleteCar(@RequestParam int id) {
        String carHapus = carService.hapusCar(id);
        return comResGen.suksesResponse(carHapus, "Berhasil hapus data");
    }
}
