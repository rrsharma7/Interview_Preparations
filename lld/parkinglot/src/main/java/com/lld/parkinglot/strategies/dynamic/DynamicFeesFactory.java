package com.lld.parkinglot.strategies.dynamic;

import com.lld.parkinglot.models.VehicleType;
import com.lld.parkinglot.strategies.FeesCalculationFactory;
import com.lld.parkinglot.strategies.FeesStrategy;

public class DynamicFeesFactory implements FeesCalculationFactory {

    @Override
    public FeesStrategy getStrategy(VehicleType vehicleType) {
        switch(vehicleType) {
            case SMALL:
                return new SmallVehicleDynamicStrategy();
            case LARGE:
            case MEDIUM:
                throw new RuntimeException("Not implemented");
        }
        
        throw new RuntimeException("Invalid type!");
    }
    
}
