package br.study.kafka.store.controllers;

import br.study.kafka.store.dto.CarPostDTO;
import br.study.kafka.store.services.CarPostService;
import br.study.kafka.store.services.OwnerPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sales")
public class CarPostController {

    @Autowired
    private CarPostService carPostService;

    @Autowired
    private OwnerPostService ownerPostService;

    @GetMapping("/car")
    public ResponseEntity<Object> getCarSales() {
        return ResponseEntity.status(HttpStatus.OK).body(carPostService.getCarPostsSales());
    }

    @PutMapping("/car/{id}")
    public ResponseEntity<Object> changeCarSales(@PathVariable Long id, @RequestBody CarPostDTO carPostDTO) {
        carPostService.changeCarPostSales(carPostDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body("Car post updated successfully.");
    }

    @DeleteMapping("/car/{id}")
    public ResponseEntity<Object> removeCarSales(@PathVariable Long id) {
        carPostService.removeCarPostSales(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Car post removed successfully.");
    }



}
