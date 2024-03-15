package repository;

import model.Gate;
import model.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {

    Map<Integer, ParkingLot> parkingLotRepo;

    public ParkingLotRepository(){
        this.parkingLotRepo = new HashMap<>();
    }

    public ParkingLotRepository(Map<Integer, ParkingLot> repo){
        this.parkingLotRepo = repo;
    }

    public ParkingLot getParkingLotByGateID(int gateId){
        if(gateId < 0)
                return null;
        for(Map.Entry<Integer, ParkingLot> entry : parkingLotRepo.entrySet()){
            ParkingLot parkingLot = entry.getValue();
            for(Gate gate : parkingLot.getGates()){
                if(gate.getId() == gateId) {
                    return parkingLot;
                }
            }
        }
        return null;
    }
}
