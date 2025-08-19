package br.study.kafka.analitic.repositories;

import br.study.kafka.analitic.models.CarAnalyticModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarAnalyticRepository extends JpaRepository<CarAnalyticModel, Long> {
    Optional<CarAnalyticModel> findByModel(String model);
}
