package br.study.kafka.api.services;

import br.study.kafka.api.clients.CarPostStoreClient;
import br.study.kafka.api.dto.CarPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarPostStoreImplService implements CarPostStoreService{

    @Autowired
    private CarPostStoreClient carPostStoreClient;

    @Override
    public List<CarPostDTO> getCarPostsSales() {
        return carPostStoreClient.getCarPostsClient();
    }

    @Override
    public void changeCarPostSales(CarPostDTO carPostDTO, String id) {
        carPostStoreClient.changeCarPostSalesClient(carPostDTO, id);
    }

    @Override
    public void removeCarPostSales(String id) {
        carPostStoreClient.removeCarPostSalesClient(id);
    }
}
