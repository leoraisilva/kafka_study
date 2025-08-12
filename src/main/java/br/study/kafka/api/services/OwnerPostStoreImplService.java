package br.study.kafka.api.services;

import br.study.kafka.api.clients.CarPostStoreClient;
import br.study.kafka.api.dto.OwnerPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostStoreImplService implements OwnerPostService {

    @Autowired
    private CarPostStoreClient carPostStoreClient;

    @Override
    public void createOwnerPost(OwnerPostDTO ownerPostDTO) {
        carPostStoreClient.ownerPostSalesClient(ownerPostDTO);
    }

}
