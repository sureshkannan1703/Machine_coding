package repository;

import model.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {

    private Map<Integer, Ticket> ticketRepository;

    public TicketRepository(Map<Integer,Ticket> repo){
        this.ticketRepository = repo;
    }

    public TicketRepository(){
        ticketRepository = new HashMap<>();
    }

    private static int ticket_id = 1;
    public Ticket putTicket(Ticket ticket){
        ticket.setId(ticket_id);
        ticketRepository.put(ticket_id++,ticket);
        return ticket;
    }
}
