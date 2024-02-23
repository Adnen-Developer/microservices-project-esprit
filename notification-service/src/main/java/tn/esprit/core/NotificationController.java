package tn.esprit.core;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
@Slf4j
public class NotificationController {

    private final NotificationRepository notificationRepository;


    // Kafka listener to receive notifications
    @KafkaListener(topics = "NotificationTopic", groupId = "NotificationGroup")
    public void listen(String notificationJson) throws IOException {
        Notification notification = JsonUtils.fromJson(notificationJson);
        log.info("Notification received: {}",notification);
        notificationRepository.save(notification);
    }


    // Endpoint to get all notifications
    @GetMapping("/")
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    // Endpoint to get notifications by user
    @GetMapping("/user/{employeeId}")
    public List<Notification> getNotificationsByUser(@PathVariable Long employeeId) {
        return notificationRepository.findAll().stream()
                .filter(notification -> employeeId.equals(notification.getEmployeeId()))
                .collect(Collectors.toList());
    }
}