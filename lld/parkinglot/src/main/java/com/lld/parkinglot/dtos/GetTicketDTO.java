package com.lld.parkinglot.dtos;

import java.time.LocalDateTime;

import com.lld.parkinglot.models.VehicleType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder(toBuilder = true)
@Setter
@Getter
public class GetTicketDTO {
	 private VehicleType vehicleType;
	 private LocalDateTime entryTime;
}