package com.programmingtechie.orderservice;

import com.programmingtechie.orderservice.event.OrderPlacedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * Hello world!
 */
@SpringBootApplication
@Slf4j
public class NotificationServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class);
    }

    @KafkaListener(topics = "notificationTopic", groupId = "notificationId",
            containerFactory = "userKafkaListenerFactory")
    public void handleNotification(OrderPlacedEvent orderPlacedEvent) {
        //send out an email notification - use SMTP or MailTrap
        log.info("Message received : {}", orderPlacedEvent.getOrderNumber());
    }
}
