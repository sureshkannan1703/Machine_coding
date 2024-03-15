package service;

import model.Ticket;
import model.VehicleType;

public interface TicketService {

    public Ticket generateTicket(int gateID, String vehicleNumber, VehicleType vehicleType) throws Exception;
}
