package repository;

import model.Gate;

import java.util.HashMap;
import java.util.Map;

public class GateRepository {

    Map<Integer, Gate> repository;
    public GateRepository(Map<Integer, Gate> repository){
        this.repository = repository;
    }

    public GateRepository(){
        this.repository = new HashMap<>();
    }

    public Gate  getGateById(int gateID){
        return repository.get(gateID);
    }
}
