package com.lld.parkinglot.strategies;

import com.lld.parkinglot.models.Ticket;

public interface FeesStrategy {
    int calculateFees(Ticket ticket);
}