package model;
import java.util.*;
public class Ticket {

    private int id;
    private Date entryTime;

    private Vehicle vehicle;

    private Spot allocatedSpot;

    private Gate gate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.util.Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(java.util.Date entryTime) {
        this.entryTime = entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Spot getAllocatedSpot() {
        return allocatedSpot;
    }

    public void setAllocatedSpot(Spot allocatedSpot) {
        this.allocatedSpot = allocatedSpot;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }
}
