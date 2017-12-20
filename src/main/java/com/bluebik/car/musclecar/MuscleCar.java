package com.bluebik.car.musclecar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Copyright © 2016 Bluebik Group.
 * Created by khakhanat on 24/10/2017 AD.
 */
@Entity
@Table(name="muscle_car")
public class MuscleCar {
	
	public MuscleCar() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@Column(name="pk_car_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pkCarId;

	
	@Column(name="brand")
    private String carBrand;
	
	@Column(name="model")
    private String carModel;
	
	@Column(name="power")
    String horsepower;
	
	@Column(name="engine")
    private String carEngine;

    public MuscleCar(String carBrand, String carModel, String horsepower, String carEngine) {
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.horsepower = horsepower;
        this.carEngine = carEngine;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(String horsepower) {
        this.horsepower = horsepower;
    }

    public String getCarEngine() {
        return carEngine;
    }

    public void setCarEngine(String carEngine) {
        this.carEngine = carEngine;
    }

	public Integer getPkCarId() {
		return pkCarId;
	}

	public void setPkCarId(Integer pkCarId) {
		this.pkCarId = pkCarId;
	}
    
}
