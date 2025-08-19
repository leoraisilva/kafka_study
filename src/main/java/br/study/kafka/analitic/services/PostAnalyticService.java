package br.study.kafka.analitic.services;

import br.study.kafka.analitic.dto.CarPostDTO;
import org.springframework.stereotype.Service;

@Service
public interface PostAnalyticService {
    void saveDataAnalytic(CarPostDTO carPostDTO);
}
