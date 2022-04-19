package com.lld.parkinglot.services;

import com.lld.parkinglot.models.ParkingSpot;
import com.lld.parkinglot.models.VehicleType;
import com.lld.parkinglot.repositories.ParkingSpotRepository;

public class SlotAllocationService {

	private ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();

	public ParkingSpot allocateSlot(VehicleType vehicleType) {
		return parkingSpotRepository.findOneByVehicleTypeAndStatusAvailable(vehicleType);
	}

}
