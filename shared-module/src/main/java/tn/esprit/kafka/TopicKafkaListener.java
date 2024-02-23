package tn.esprit.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TopicKafkaListener {

    @KafkaListener(groupId = "NotificationGroup",topics = "NotificationTopic")
    void listeners(String data){
      log.info("Listener receiver: {}",data);
    }

}
