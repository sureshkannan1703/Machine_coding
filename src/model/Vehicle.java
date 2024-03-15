package model;

public class Vehicle extends BaseModel{

    private String vehicleNumder;

    private VehicleType vehicleType;

    public String getVehicleNumder() {
        return vehicleNumder;
    }

    public void setVehicleNumder(String vehicleNumder) {
        this.vehicleNumder = vehicleNumder;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
