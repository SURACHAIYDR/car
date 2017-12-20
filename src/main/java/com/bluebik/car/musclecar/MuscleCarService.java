package com.bluebik.car.musclecar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright © 2016 Bluebik Group.
 * Created by khakhanat on 24/10/2017 AD.
 */
@Service
public class MuscleCarService {
	
	@Autowired
    private MuscleCarDao muscleCarDao;

//    public MuscleCarService() {
//        this.muscleCarDao = new MuscleCarDaoImpl();
//    }

    public MuscleCar getCar(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID can not be 0 or <0");
        }
        return muscleCarDao.getCarFromList(id);
    }

    public void removeCarFromList(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID can not be 0 or <0 or this id do not exist");
        }
        muscleCarDao.removeCarFromList(id);
    }

    public List<MuscleCar> listAllCars() {

        List<MuscleCar> result = muscleCarDao.listAllCars();
        if (result.size() > 0) {
            return result;
        } else {
            return null;
        }
    }

    public void addCarToList(MuscleCar muscleCar) {
        if (muscleCar == null) {
            throw new IllegalArgumentException("The passed object cna not be null.");
        }
        muscleCarDao.addCarToList(muscleCar);
    }

    public void updateCarFromList(int id, MuscleCar muscleCar) {
        if (id <= 0 && muscleCar == null) {
            throw new IllegalArgumentException("The passed object cna not be null.");
        }
        muscleCarDao.updateCarFromList(id, muscleCar);
    }

}
