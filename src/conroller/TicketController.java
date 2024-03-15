package conroller;

import dto.GenerateTicketRequestDTO;
import dto.GenerateTicketResponseDTO;
import dto.Response;
import dto.ResponseStatus;
import model.Ticket;
import service.TicketService;

public class TicketController {

    TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    public GenerateTicketResponseDTO generateTicket(GenerateTicketRequestDTO requestDTO){

        GenerateTicketResponseDTO responseDTO = new GenerateTicketResponseDTO();
        Response response = new Response();
        try {
            if (requestDTO.getGateId() < 0)
                throw new IllegalArgumentException("Invalid Gate number : " + requestDTO.getGateId());
            String vehicle_number = requestDTO.getVehicleNumber();
            if (vehicle_number == null || vehicle_number.equals("")) {
                throw new IllegalArgumentException("Invalid vehicle number : " + vehicle_number);
            }
        }
        catch(IllegalArgumentException ex){
            response.setError(ex.getMessage());
            response.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setResponse(response);
            return responseDTO;
        }

        try{
            Ticket ticket = ticketService.generateTicket(requestDTO.getGateId(),requestDTO.getVehicleNumber(),requestDTO.getVehicleType());
            responseDTO.setTicket(ticket);
            response.setResponseStatus(ResponseStatus.SUCCESS);
        }catch(Exception ex){
            response.setResponseStatus(ResponseStatus.FAILURE);
        }
        responseDTO.setResponse(response);
        return responseDTO;
    }
}
