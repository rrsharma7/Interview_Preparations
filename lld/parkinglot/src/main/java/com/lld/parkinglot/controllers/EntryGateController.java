package com.lld.parkinglot.controllers;

import com.lld.parkinglot.dtos.GetTicketDTO;
import com.lld.parkinglot.models.VehicleType;
import com.lld.parkinglot.services.EntryGateService;

public class EntryGateController {
	EntryGateService entryGateService = new EntryGateService();

	public GetTicketDTO createTicket(VehicleType vehicleType) {
		return entryGateService.createTicket(vehicleType);
	}
}