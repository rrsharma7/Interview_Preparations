package com.lld.parkinglot.services;

import com.lld.parkinglot.models.Ticket;
import com.lld.parkinglot.strategies.FeesStrategy;
import com.lld.parkinglot.strategies.FeesStrategyFactory;

public class FeeCalculatorService {
	private static final String PRICING_SCHEME = "TimeBased";

	public int calculateFees(Ticket ticket) {
		FeesStrategy feesStrategy = FeesStrategyFactory.getFactory(PRICING_SCHEME).
				getStrategy(ticket.getVehicleType());
		return feesStrategy.calculateFees(ticket);
	}
}
