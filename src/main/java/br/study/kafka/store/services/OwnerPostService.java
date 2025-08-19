package br.study.kafka.store.services;

import br.study.kafka.store.dto.OwnerPostDTO;
import org.springframework.stereotype.Service;

@Service
public interface OwnerPostService {
    void createOwnerPost(OwnerPostDTO ownerPostDTO);

}
