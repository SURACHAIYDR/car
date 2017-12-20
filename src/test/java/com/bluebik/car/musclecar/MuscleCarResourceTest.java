package com.bluebik.car.musclecar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Copyright © 2016 Bluebik Group.
 * Created by khakhanat on 24/10/2017 AD.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MuscleCarResourceTest {

    @Autowired
    MuscleCarService muscleCarService;

    @Autowired
    MuscleCarResource muscleCarResource;

    @Test
    public void addCarToList() throws Exception {
        ResponseEntity<Void> responseEntity = muscleCarResource.addCarToList(
            new MuscleCar("brand", "model", "power", "engine")
        );
    }

    @Test
    public void getMuscleCar() throws Exception {
        ResponseEntity<MuscleCar> response = muscleCarResource.getMuscleCar(1);
        MuscleCar muscleCar = response.getBody();
        Assert.assertEquals("brand", muscleCar.getCarBrand());
        Assert.assertEquals("model", muscleCar.getCarModel());
        Assert.assertEquals("power", muscleCar.getHorsepower());
        Assert.assertEquals("engine", muscleCar.getCarEngine());

    }

    @Test
    public void deleteMuscleCar() throws Exception {
        ResponseEntity<Void> responseEntity = muscleCarResource.deleteMuscleCar(1);
    }

   
    @Test
    public void listAllCars() throws Exception {
        ResponseEntity<List<Map<String, Object>>> listResponseEntity = muscleCarResource.listAllCars();
        Assert.assertEquals(1, listResponseEntity.getBody().size());
    }

    @Test
    public void updateCar() throws Exception {
        ResponseEntity<Void> responseEntity = muscleCarResource.updateCar(1,
            new MuscleCar("brand", "model", "power", "engine")
        );
    }

}