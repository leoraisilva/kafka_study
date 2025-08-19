package br.study.kafka.store.services;

import br.study.kafka.store.dto.OwnerPostDTO;
import br.study.kafka.store.models.OwnerPostModel;
import br.study.kafka.store.repositories.OwnerPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostImplService implements OwnerPostService{
    @Autowired
    private OwnerPostRepository ownerPostRepository;

    @Override
    public void createOwnerPost(OwnerPostDTO ownerPostDTO) {
        OwnerPostModel ownerPostModel = new OwnerPostModel();
        ownerPostModel.setOwnerName(ownerPostDTO.getName());
        ownerPostModel.setOwnerType(ownerPostDTO.getType());
        ownerPostModel.setOwnerContact(ownerPostDTO.getContactNumber());

        ownerPostRepository.save(ownerPostModel);
    }
}
