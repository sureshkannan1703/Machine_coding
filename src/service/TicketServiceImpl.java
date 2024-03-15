package service;

import model.*;
import repository.ParkingLotRepository;
import repository.TicketRepository;
import repository.VehicleRepository;
import stratergies.parkingSpotAssignStratergy.AssignParkingSpot;

import java.util.Date;

public class TicketServiceImpl implements TicketService{

    GateService gateService;
    ParkingLotRepository parkingLotRepository;
    AssignParkingSpot assignParkingSpot;
    VehicleRepository vehicleRepository;

    TicketRepository ticketRepository;

    public TicketServiceImpl(GateService gateService,AssignParkingSpot assignParkingSpot,VehicleRepository vehicleRepository,ParkingLotRepository parkingLotRepository,TicketRepository ticketRepository){
        this.gateService = gateService;
        this.parkingLotRepository = parkingLotRepository;
        this.vehicleRepository = vehicleRepository;
        this.ticketRepository = ticketRepository;
        this.assignParkingSpot = assignParkingSpot;
    }
    @Override
    public Ticket generateTicket(int gateID, String vehicleNumber, VehicleType vehicleType) throws Exception {

        Gate gate = gateService.getGateById(gateID);
        Vehicle vehicle = vehicleRepository.createVehicleIfNotExist(vehicleNumber,vehicleType);
        ParkingLot parkingLot = parkingLotRepository.getParkingLotByGateID(gate.getId());
        if(parkingLot == null){
            throw new Exception("Invalid gate id "+gate.getId());
        }

        Spot spot = assignParkingSpot.assignVehicleSpot(vehicleType,parkingLot);
        Ticket ticket = new Ticket();
        ticket.setAllocatedSpot(spot);
        ticket.setGate(gate);
        ticket.setVehicle(vehicle);
        ticket.setEntryTime(new Date());
        return ticketRepository.putTicket(ticket);
    }
}
