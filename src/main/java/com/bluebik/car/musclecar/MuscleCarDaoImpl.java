package com.bluebik.car.musclecar;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Copyright © 2016 Bluebik Group.
 * Created by khakhanat on 24/10/2017 AD.
 */
@Repository
public class MuscleCarDaoImpl  implements MuscleCarDao {

	@PersistenceContext	
	private EntityManager entityManager;	
	
    public MuscleCarDaoImpl() {
    }

    @Override
    public MuscleCar getCarFromList(int id) {
    	return entityManager.find(MuscleCar.class, id);
       
    }

    @Override
    public void removeCarFromList(int id) {
    	entityManager.remove(getCarFromList(id));
    }

    @Override
    @Transactional
    public void addCarToList(MuscleCar muscleCar) {
    	entityManager.persist(muscleCar);
    	
    }

    @Override
    @Transactional
    public void updateCarFromList(int id, MuscleCar muscleCar) {
    	MuscleCar muscleCarForUpdate = getCarFromList(id);
    	if (muscleCarForUpdate != null) {
    		muscleCarForUpdate.setCarBrand(muscleCar.getCarBrand());
    		muscleCarForUpdate.setCarEngine(muscleCar.getCarEngine());
    		muscleCarForUpdate.setCarModel(muscleCar.getCarModel());
    		muscleCarForUpdate.setHorsepower(muscleCar.getHorsepower());
    		entityManager.merge(muscleCarForUpdate);
		}
    	
    }

    @Override
    public List<MuscleCar> listAllCars() {
    	String hql = "FROM MuscleCar";
		return entityManager.createQuery(hql).getResultList();
    	
        
    }

}
