package com.example.juniorspring.apicrud.controllers;

import com.example.juniorspring.apicrud.entities.CarEntity;
import com.example.juniorspring.apicrud.entities.CarImage;
import com.example.juniorspring.apicrud.repositories.CarImageRepository;
import com.example.juniorspring.apicrud.repositories.CarRepository;
import com.example.juniorspring.apicrud.responses.CommonResponse;
import com.example.juniorspring.apicrud.responses.CommonResponseGenerator;
import com.example.juniorspring.apicrud.services.CarService;
import com.example.juniorspring.apicrud.wrappers.CarImageWrapper;
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
        try{
            CarEntity cr = carService.tambahCar(param);
            return comResGen.suksesResponse(cr, "Berhasil menambah data");
        } catch (Exception e) {
            return comResGen.failedResponse(e.getMessage());
        }
    }

    @GetMapping(value = "getAllCar")
    public CommonResponse<List<CarEntity>> getAllCar() {
        try {
            List<CarEntity> carList = carService.getAllData();
            return comResGen.suksesResponse(carList, "Berhasil menampilkan semua data");
        } catch (Exception e) {
            return comResGen.failedResponse(e.getMessage());
        }
    }

    @GetMapping(value = "getById")
    public CommonResponse<CarEntity> getById(@RequestParam int id) {
        try {
            CarEntity carById = carService.getCarById(id);
            return comResGen.suksesResponse(carById, "Berhasil menampilkan data");
        } catch (Exception e) {
            return comResGen.failedResponse(e.getMessage());
        }
    }

    @PostMapping(value = "apdetCar")
    public CommonResponse<CarEntity> updateCar(@RequestBody CarEntity param) {
        try {
            CarEntity carApdet = carService.apdetCar(param);
            return comResGen.suksesResponse(carApdet, "Berhasil edit data");
        } catch (Exception e) {
            return comResGen.failedResponse(e.getMessage()+ " for id: "+param.getId());
        }
    }

    @GetMapping(value = "deletCar")
    public CommonResponse<String> deleteCar(@RequestParam int id) {
        try {
            String carHapus = carService.hapusCar(id);
            return comResGen.suksesResponse(carHapus, "Berhasil hapus data");
        } catch (Exception e) {
            return comResGen.failedResponse(e.getMessage());
        }
    }

    @PostMapping(value = "upload-car")
    public CommonResponse<CarImage> upload(@RequestBody CarImageWrapper param) {
        try {
            CarImage car = carService.upload(param);
            return comResGen.suksesResponse(car,  "Berhasil upload image");
        } catch (Exception e) {
            return comResGen.failedResponse(e.getMessage());
        }
    }
}
