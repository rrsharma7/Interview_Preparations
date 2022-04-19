package com.lld.parkinglot.strategies;

import com.lld.parkinglot.models.VehicleType;

public interface FeesCalculationFactory {
	public FeesStrategy getStrategy(VehicleType vehicleType);
}
