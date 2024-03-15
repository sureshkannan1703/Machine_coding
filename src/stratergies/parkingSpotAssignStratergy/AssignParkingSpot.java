package stratergies.parkingSpotAssignStratergy;

import exception.NoSpotAvailableException;
import model.ParkingLot;
import model.Spot;
import model.VehicleType;

public interface AssignParkingSpot {

    public Spot assignVehicleSpot(VehicleType vehicleType, ParkingLot parkingLot) throws NoSpotAvailableException;
}
