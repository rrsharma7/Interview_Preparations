package com.lld.parkinglot.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ParkingFloor {
	private Integer floorNumber;
	private String name;
	private List<ParkingSpot> spots = new ArrayList<>();

}
