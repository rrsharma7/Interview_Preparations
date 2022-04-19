package com.lld.parkinglot.services;

import com.lld.parkinglot.models.ParkingSpot;
import com.lld.parkinglot.repositories.ParkingSpotRepository;

public class ParkingSpotService {
	private ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();

	public void markSlotBooked(ParkingSpot spot) {
	        parkingSpotRepository.save(spot);
}
}
