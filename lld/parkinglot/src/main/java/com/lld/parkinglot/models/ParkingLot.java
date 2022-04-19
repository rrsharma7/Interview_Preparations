package com.lld.parkinglot.models;

import java.util.*;

import lombok.Data;

@Data
public class ParkingLot {

	private String address;
	private List<ParkingFloor> floors = new ArrayList<>();
	private List<EntryGate> entryGate = new ArrayList<>();
	private List<ExitGate> exitGate = new ArrayList<>();

}
