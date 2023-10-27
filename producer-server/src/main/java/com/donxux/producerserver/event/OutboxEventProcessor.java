package com.donxux.producerserver.event;

import com.donxux.producerserver.model.OutboxEvent;
import com.donxux.producerserver.repository.OutboxEventRepository;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class OutboxEventProcessor {
    private static final String TOPIC_NAME = "outbox-events";

    private final OutboxEventRepository outboxEventRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Scheduled(fixedRate = 5000)
    public void processUnpublishedEvents() {
        System.out.println("run processUnpublishedEvents");
        List<OutboxEvent> events = outboxEventRepository.findAll();

        for (OutboxEvent event : events) {
            publish(event);
        }
    }

    private void publish(OutboxEvent event) {
        kafkaTemplate.send(TOPIC_NAME, event.getAggregateType(), event.getPayload());
    }
}
