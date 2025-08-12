package br.study.kafka.api.services;

import br.study.kafka.api.dto.CarPostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarPostStoreService {
    List<CarPostDTO> getCarPostsSales();
    void changeCarPostSales(CarPostDTO carPostDTO, String id);
    void removeCarPostSales(String id);
}
