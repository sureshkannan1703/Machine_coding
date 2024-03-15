package stratergies.parkingSpotAssignStratergy;

import exception.NoSpotAvailableException;
import model.*;

public class AssignNearestSpotStratergy implements AssignParkingSpot{
    @Override
    public Spot assignVehicleSpot(VehicleType vehicleType, ParkingLot parkingLot) throws NoSpotAvailableException {

        for(Floor floor : parkingLot.getFloors()){
            for(Section section : floor.getSections()){
                for(Spot spot : section.getSpots()){
                    if(spot.getVehicleType() == vehicleType && spot.getSpotStatus() == SpotStatus.AVAILABLE){
                        return spot;
                    }
                }
            }
        }
        throw new NoSpotAvailableException("Spot not exist for vehicle type "+vehicleType);
    }
}
