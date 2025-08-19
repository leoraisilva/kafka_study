package br.study.kafka.store.controllers;

import br.study.kafka.store.dto.OwnerPostDTO;
import br.study.kafka.store.services.OwnerPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class OwnerPostController {

    @Autowired
    private OwnerPostService ownerPostService;

    @PostMapping
    public ResponseEntity<Object> createOwnerPost(@RequestBody OwnerPostDTO ownerPostDTO) {
        ownerPostService.createOwnerPost(ownerPostDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Created owner post successfully.");
    }
}
