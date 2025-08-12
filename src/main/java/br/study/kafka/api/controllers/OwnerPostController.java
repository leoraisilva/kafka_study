package br.study.kafka.api.controllers;

import br.study.kafka.api.dto.OwnerPostDTO;
import br.study.kafka.api.services.OwnerPostStoreImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/owner")
public class OwnerPostController {

    @Autowired
    private OwnerPostStoreImplService ownerPostStoreImplService;

    @PostMapping
    public ResponseEntity<Object> createOwnerPost(@RequestBody OwnerPostDTO ownerPostDTO) {
        ownerPostStoreImplService.createOwnerPost(ownerPostDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
