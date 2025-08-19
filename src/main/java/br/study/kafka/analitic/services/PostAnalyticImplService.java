package br.study.kafka.analitic.services;

import br.study.kafka.analitic.dto.CarPostDTO;
import br.study.kafka.analitic.models.CarAnalyticModel;
import br.study.kafka.analitic.models.CarAnalyticPrice;
import br.study.kafka.analitic.models.DataAnalyticModel;
import br.study.kafka.analitic.repositories.CarAnalyticPriceRepository;
import br.study.kafka.analitic.repositories.CarAnalyticRepository;
import br.study.kafka.analitic.repositories.DataAnalyticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostAnalyticImplService implements PostAnalyticService{

    @Autowired
    private CarAnalyticRepository carAnalyticRepository;

    @Autowired
    private DataAnalyticRepository dataAnalyticRepository;

    @Autowired
    private CarAnalyticPriceRepository carAnalyticPriceRepository;

    @Override
    public void saveDataAnalytic(CarPostDTO carPostDTO) {
        saveModelAnalytic(carPostDTO.getBrand());
        saveCarAnalyticModel(carPostDTO.getModel());
        saveCarAnalyticPrice(carPostDTO.getModel(), carPostDTO.getPrice());
    }

    private void saveModelAnalytic(String brand) {
        var dataAnalyticModel = new DataAnalyticModel();
        dataAnalyticRepository.findByBrand(brand)
                .ifPresentOrElse(
                        existingModel -> {
                            existingModel.setPosts(existingModel.getPosts() + 1);
                            dataAnalyticRepository.save(existingModel);
                        },
                        () -> {
                            dataAnalyticModel.setBrand(brand);
                            dataAnalyticModel.setPosts(1L);
                            dataAnalyticRepository.save(dataAnalyticModel);
                        }
                );
    }

    private void saveCarAnalyticModel(String model) {
        var carAnalyticModel = new CarAnalyticModel();

        carAnalyticRepository.findByModel(model)
                .ifPresentOrElse(
                        existingModel -> {
                            existingModel.setPosts(existingModel.getPosts() + 1);
                            carAnalyticRepository.save(existingModel);
                        },
                        () -> {
                            carAnalyticModel.setModel(model);
                            carAnalyticModel.setPosts(1L);
                            carAnalyticRepository.save(carAnalyticModel);
                        }
                );
    }

    private void saveCarAnalyticPrice(String model, Double price) {
        var carAnalyticPriceModel = new CarAnalyticPrice();

        carAnalyticPriceModel.setPrice(price);
        carAnalyticPriceModel.setModel(model);
        carAnalyticPriceRepository.save(carAnalyticPriceModel);

    }

}
