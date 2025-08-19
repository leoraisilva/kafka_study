package br.study.kafka.store.messages;

import br.study.kafka.store.dto.CarPostDTO;
import br.study.kafka.store.services.CarPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;



@Component
public class KafkaConsumerMessage {
    private final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerMessage.class.getName());

    @Autowired
    private CarPostService carPostService;

    @KafkaListener(topics = "car-post-topic", groupId = "store-post-group")
    public void listerning(CarPostDTO carPostDTO) {
        LOGGER.info("Received message: {}", carPostDTO);
        carPostService.newPostDetails(carPostDTO);
    }

}
