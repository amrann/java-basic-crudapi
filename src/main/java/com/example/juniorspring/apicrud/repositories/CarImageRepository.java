package com.example.juniorspring.apicrud.repositories;

import com.example.juniorspring.apicrud.entities.CarImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarImageRepository extends JpaRepository<CarImage, Integer> {
}
