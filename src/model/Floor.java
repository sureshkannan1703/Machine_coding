package model;
import java.util.*;
public class Floor extends BaseModel{

    private int id;
    @Override
    public void setId(int id){
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    private List<Section> sections;

    private FloorStatus floorStatus;

    private int floorNum;

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public FloorStatus getFloorStatus() {
        return floorStatus;
    }

    public void setFloorStatus(FloorStatus floorStatus) {
        this.floorStatus = floorStatus;
    }

    public int getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(int floorNum) {
        this.floorNum = floorNum;
    }
}
