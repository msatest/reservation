package ticketreservation;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Ticketlist_table")
public class Ticketlist {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String ticketid;
        private String status;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public String getTicketid() {
            return ticketid;
        }

        public void setTicketid(String ticketid) {
            this.ticketid = ticketid;
        }
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

}
