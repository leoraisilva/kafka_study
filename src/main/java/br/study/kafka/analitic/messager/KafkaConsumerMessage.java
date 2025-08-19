package br.study.kafka.analitic.messager;

import br.study.kafka.analitic.dto.CarPostDTO;
import br.study.kafka.analitic.services.PostAnalyticService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerMessage {
    private final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerMessage.class);

    @Autowired
    private PostAnalyticService postAnalyticService;

    @KafkaListener(topics = "car-post-topic", groupId = "car-post-analytic")
    public void listening(@Payload CarPostDTO carPostDTO) {
        LOGGER.info("Message received: {}", carPostDTO);
        postAnalyticService.saveDataAnalytic(carPostDTO);
    }


}
