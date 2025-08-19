package br.study.kafka.store.services;

import br.study.kafka.store.dto.CarPostDTO;
import br.study.kafka.store.models.CarPostModel;
import br.study.kafka.store.repositories.CarPostRepository;
import br.study.kafka.store.repositories.OwnerPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

@Service
public class CarPostImplService implements CarPostService {
    @Autowired
    private CarPostRepository carPostRepository;

    @Autowired
    private OwnerPostRepository ownerPostRepository;

    @Override
    public void newPostDetails(CarPostDTO carPostDTO) {
        CarPostModel carPostModel = mapCarPostDTOToModel(carPostDTO);
        carPostRepository.save(carPostModel);
    }

    @Override
    public List<CarPostDTO> getCarPostsSales() {
        List<CarPostDTO> carPostDTOList = new ArrayList<CarPostDTO>();
        carPostRepository.findAll().forEach(item -> {
            carPostDTOList.add(mapCarPostModelToDTO(item));
        });
        return carPostDTOList;
    }

    @Override
    public void changeCarPostSales(CarPostDTO carPostDTO, Long id) {
        carPostRepository.findById(id).ifPresentOrElse(
            carPostModel -> {
                carPostModel.setModel(carPostDTO.getModel());
                carPostModel.setBrand(carPostDTO.getBrand());
                carPostModel.setPrice(carPostDTO.getPrice());
                carPostModel.setDescription(carPostDTO.getDescription());
                carPostModel.setEngineVersion(carPostDTO.getEngineVersion());
                carPostModel.setCity(carPostDTO.getCity());
                carPostModel.setContact(carPostDTO.getContact());
                carPostRepository.save(carPostModel);
            },
            () -> {
                throw new RuntimeException("Car post not found with id: " + id);
            }
        );
    }

    @Override
    public void removeCarPostSales(Long id) {
        carPostRepository.deleteById(id);
    }

    private CarPostDTO mapCarPostModelToDTO(CarPostModel carPostModel) {
        return CarPostDTO.builder(
                carPostModel.getModel(),
                carPostModel.getBrand(),
                carPostModel.getPrice(),
                carPostModel.getDescription(),
                carPostModel.getEngineVersion(),
                carPostModel.getCity(),
                carPostModel.getCreatedDate(),
                carPostModel.getOwnerId(),
                carPostModel.getOwnerPostModel().getOwnerName(),
                carPostModel.getOwnerPostModel().getOwnerType(),
                carPostModel.getContact()
        );
    }

    private CarPostModel mapCarPostDTOToModel(CarPostDTO carPostDTO) {
        CarPostModel carPostModel = new CarPostModel();

        ownerPostRepository.findById(carPostDTO.getOwnerId()).ifPresentOrElse(
            ownerPostModel -> {
                carPostModel.setOwnerPostModel(ownerPostModel);
                carPostModel.setContact(ownerPostModel.getOwnerContact());
            },
            () -> {
                throw new RuntimeException("Owner post not found with id: " + carPostDTO.getOwnerId());
            }
        );

        carPostModel.setModel(carPostDTO.getModel());
        carPostModel.setBrand(carPostDTO.getBrand());
        carPostModel.setPrice(carPostDTO.getPrice());
        carPostModel.setDescription(carPostDTO.getDescription());
        carPostModel.setEngineVersion(carPostDTO.getEngineVersion());
        carPostModel.setCity(carPostDTO.getCity());
        carPostModel.setCreatedDate(carPostDTO.getCreatedDate());
        carPostModel.setOwnerId(carPostDTO.getOwnerId());
        carPostModel.setContact(carPostDTO.getContact());
        return carPostModel;
    }

}
