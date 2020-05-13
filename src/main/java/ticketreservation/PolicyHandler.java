package ticketreservation;

import ticketreservation.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverTicketregistered_Statusupdate(@Payload Ticketregistered ticketregistered){

        if(ticketregistered.isMe()){
            System.out.println("##### listener Statusupdate : " + ticketregistered.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPaycompleted_Statusupdate(@Payload Paycompleted paycompleted){

        if(paycompleted.isMe()){
            System.out.println("##### listener Statusupdate : " + paycompleted.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPayCanceled_Statusupdate(@Payload PayCanceled payCanceled){

        if(payCanceled.isMe()){
            System.out.println("##### listener Statusupdate : " + payCanceled.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPayfailed_Statusupdate(@Payload Payfailed payfailed){

        if(payfailed.isMe()){
            System.out.println("##### listener Statusupdate : " + payfailed.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDisable_Statusupdate(@Payload Disable disable){

        if(disable.isMe()){
            System.out.println("##### listener Statusupdate : " + disable.toJson());
        }
    }

}
