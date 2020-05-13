package ticketreservation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketlistRepository extends CrudRepository<Ticketlist, Long> {

    List<Ticketlist> findByTicketid(String ticketid);

}