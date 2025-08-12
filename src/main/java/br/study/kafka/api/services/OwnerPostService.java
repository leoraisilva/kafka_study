package br.study.kafka.api.services;

import br.study.kafka.api.dto.OwnerPostDTO;
import org.springframework.stereotype.Service;

@Service
public interface OwnerPostService {
    void createOwnerPost(OwnerPostDTO ownerPostDTO);
}
