package ticketreservation;

import ticketreservation.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class TicketlistViewHandler {


    @Autowired
    private TicketlistRepository ticketlistRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenTicketregistered_then_CREATE_1 (@Payload Ticketregistered ticketregistered) {
        try {
            if (ticketregistered.isMe()) {
                // view 객체 생성
                Ticketlist ticketlist = new Ticketlist();
                // view 객체에 이벤트의 Value 를 set 함
                ticketlist.setTicketid(ticketregistered.getTicketid());
                // view 레파지 토리에 save
                ticketlistRepository.save(ticketlist);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaycompleted_then_UPDATE_1(@Payload Paycompleted paycompleted) {
        try {
            if (paycompleted.isMe()) {
                // view 객체 조회
                List<Ticketlist> ticketlistList = ticketlistRepository.findByTicketid(paycompleted.getTicketid());
                for(Ticketlist ticketlist : ticketlistList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    ticketlist.setStatus(paycompleted.getStatus());
                    // view 레파지 토리에 save
                    ticketlistRepository.save(ticketlist);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenAble_then_UPDATE_2(@Payload Able able) {
        try {
            if (able.isMe()) {
                // view 객체 조회
                List<Ticketlist> ticketlistList = ticketlistRepository.findByTicketid(able.getTicketid());
                for(Ticketlist ticketlist : ticketlistList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    ticketlist.setStatus(able.getStatus());
                    // view 레파지 토리에 save
                    ticketlistRepository.save(ticketlist);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDisable_then_UPDATE_3(@Payload Disable disable) {
        try {
            if (disable.isMe()) {
                // view 객체 조회
                List<Ticketlist> ticketlistList = ticketlistRepository.findByTicketid(disable.getTicketid());
                for(Ticketlist ticketlist : ticketlistList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    ticketlist.setStatus(disable.getStatus());
                    // view 레파지 토리에 save
                    ticketlistRepository.save(ticketlist);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}