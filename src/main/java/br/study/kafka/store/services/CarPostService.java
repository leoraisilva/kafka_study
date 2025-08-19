package br.study.kafka.store.services;

import br.study.kafka.store.dto.CarPostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarPostService {
    void newPostDetails(CarPostDTO carPostDTO);
    List<CarPostDTO> getCarPostsSales();
    void changeCarPostSales(CarPostDTO carPostDTO, Long id);
    void removeCarPostSales(Long id);
}
