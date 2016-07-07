package dao;

import java.util.List;

public interface TicketDAO {

    void addTicket(Ticket ticket);
    List<Ticket> selectAll();
    void deleteAll();
    void close();
}
