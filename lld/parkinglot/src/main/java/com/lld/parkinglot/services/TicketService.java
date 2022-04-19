package com.lld.parkinglot.services;

import java.time.LocalDateTime;

import com.lld.parkinglot.models.ParkingSpot;
import com.lld.parkinglot.models.Ticket;
import com.lld.parkinglot.models.VehicleType;
import com.lld.parkinglot.repositories.TicketRepository;

public class TicketService {
	private TicketRepository ticketRepository = new TicketRepository();

	public Ticket createTicket(VehicleType vehicleType, ParkingSpot spot) {

        Ticket ticket = Ticket
                .builder()
                .entryTime(LocalDateTime.now())
                .floorNumber(spot.getFloorNumber())
                .slotNumber(spot.getSpotId())
                .build();

        return ticketRepository.save(ticket);
}

}