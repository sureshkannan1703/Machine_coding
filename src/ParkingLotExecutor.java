import model.*;
import repository.GateRepository;
import repository.ParkingLotRepository;
import repository.TicketRepository;
import repository.VehicleRepository;
import service.GateService;
import service.TicketService;
import service.TicketServiceImpl;
import stratergies.parkingSpotAssignStratergy.AssignNearestSpotStratergy;
import stratergies.parkingSpotAssignStratergy.AssignParkingSpot;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ParkingLotExecutor {

    public static void main(String[] args) {

        //Creating simple In memory repository.
        Gate gate = new Gate();
        gate.setGateName("ABC");
        gate.setGateType(GateType.ENTRY);
        gate.setId(1);

        Map<Integer, Gate> gateMap = new HashMap<>(){{
            put(1,gate);
        }};

        GateRepository repository = new GateRepository(gateMap);
        TicketRepository ticketRepository = new TicketRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();

        GateService gateService = new GateService(repository);
        AssignParkingSpot assignParkingSpot = new AssignNearestSpotStratergy();

        Spot spot = new Spot();
        Section section = new Section();
        section.setSpots(Arrays.asList(new Spot[]{spot}));
        section.setSectionName("First section");

        Floor floor = new Floor();
        floor.setSections(Arrays.asList(new Section[]{section}));
        floor.setFloorNum(2);
        floor.setFloorStatus(FloorStatus.AVAILABLE);

        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setFloors(Arrays.asList(new Floor[]{floor}));
        parkingLot.setGates(Arrays.asList(new Gate[]{gate}));

        Map<Integer, ParkingLot> lotMap = new HashMap<>(){{
            put(1,parkingLot);
        }};
        ParkingLotRepository parkingLotRepo = new ParkingLotRepository(lotMap);

        TicketService ticketService = new TicketServiceImpl(gateService,assignParkingSpot,vehicleRepository,parkingLotRepo,ticketRepository);
    }

}
