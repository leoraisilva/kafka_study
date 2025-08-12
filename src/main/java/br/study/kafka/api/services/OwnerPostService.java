package br.study.kafka.api.services;

import org.springframework.stereotype.Service;

@Service
public interface OwnerPostService {
    void createOwnerPost(String ownerPostDTO);
}
