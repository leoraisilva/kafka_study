package br.study.kafka.api.controllers;

import br.study.kafka.api.dto.CarPostDTO;
import br.study.kafka.api.message.KafkaProducerConfig;
import br.study.kafka.api.message.KafkaProducerMessage;
import br.study.kafka.api.services.CarPostStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/car")
public class CarPostController {
    @Autowired
    private CarPostStoreService carPostStoreService;

    @Autowired
    private KafkaProducerMessage kafkaProducerMessage;

    @PostMapping
    public ResponseEntity<Object> createCarSales(@RequestBody CarPostDTO carPostDTO) {
        kafkaProducerMessage.sendMessage(carPostDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/post")
    public ResponseEntity<List<CarPostDTO>> getCarSales() {
        List<CarPostDTO> carPostDTOList = carPostStoreService.getCarPostsSales();
        return ResponseEntity.status(HttpStatus.OK).body(carPostDTOList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> changeCarSales(@PathVariable("id") String id, @RequestBody CarPostDTO carPostDTO) {
        carPostStoreService.changeCarPostSales(carPostDTO, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCarSales(@PathVariable("id") String id) {
        carPostStoreService.removeCarPostSales(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
