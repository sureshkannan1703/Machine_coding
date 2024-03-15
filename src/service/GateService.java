package service;

import model.Gate;
import repository.GateRepository;

public class GateService {

    GateRepository gateRepository;

    public GateService(GateRepository gateRepository){
        this.gateRepository = gateRepository;
    }

    public Gate getGateById(int gateId){
        return gateRepository.getGateById(gateId);
    }
}
