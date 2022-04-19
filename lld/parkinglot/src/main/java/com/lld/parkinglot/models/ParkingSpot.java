package com.lld.parkinglot.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ParkingSpot extends BaseModel {

	private Integer spotId;
	private Integer floorNumber;
	private VehicleType vehicleType;
	private SpotStatus spotStatus;
	

	
}
