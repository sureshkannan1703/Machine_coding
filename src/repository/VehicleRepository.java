package repository;

import model.Vehicle;
import model.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class VehicleRepository {

    Map<Integer, Vehicle> vehicleRepository;

    public VehicleRepository(Map<Integer,Vehicle> vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }

    public VehicleRepository(){
        this.vehicleRepository = new HashMap<>();
    }

    private static int vehicle_id = 1;

    public Vehicle createVehicleIfNotExist(String vehicleNumber, VehicleType vehicleType){

        for(Map.Entry<Integer, Vehicle> entry : vehicleRepository.entrySet()){
            if(entry.getValue().getVehicleNumder().equals(vehicleNumber)){
                return entry.getValue();
            }
        }

        Vehicle vehicle  = new Vehicle();
        vehicle.setVehicleNumder(vehicleNumber);
        vehicle.setVehicleType(vehicleType);
        vehicle.setId(vehicle_id);
        vehicleRepository.put(vehicle_id++,vehicle);
        return vehicle;
    }
}
