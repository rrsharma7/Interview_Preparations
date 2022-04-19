package com.lld.parkinglot.strategies.timebased;

import com.lld.parkinglot.models.Vehicle;
import com.lld.parkinglot.models.VehicleType;
import com.lld.parkinglot.strategies.FeesCalculationFactory;
import com.lld.parkinglot.strategies.FeesStrategy;

public class TimeBasedFeesStrategyFactory implements FeesCalculationFactory {

    public FeesStrategy getStrategy(VehicleType vehicleType) {
        
        switch (vehicleType) {
            case LARGE:
                return new LargeVehicleTimeStrategy();
            case MEDIUM:
                return new MediumVehicleTimeStrategy();
            case SMALL:
                return new SmallVehicleTimeStrategy();
        }

        throw new RuntimeException("Invalid type");
    }
}
