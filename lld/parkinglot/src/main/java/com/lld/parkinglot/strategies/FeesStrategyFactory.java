package com.lld.parkinglot.strategies;

import com.lld.parkinglot.strategies.timebased.TimeBasedFeesStrategyFactory;
import com.lld.parkinglot.strategies.dynamic.DynamicFeesFactory;

public class FeesStrategyFactory {

	public static FeesCalculationFactory getFactory(String pricingScheme) {

		switch (pricingScheme) {
		case "TimeBased":
			return new TimeBasedFeesStrategyFactory();
		case "Dynamic":
			return new DynamicFeesFactory();
		}

		throw new RuntimeException();
	}
}
