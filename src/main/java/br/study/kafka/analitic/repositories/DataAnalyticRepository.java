package br.study.kafka.analitic.repositories;

import br.study.kafka.analitic.models.DataAnalyticModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DataAnalyticRepository extends JpaRepository<DataAnalyticModel, Long> {
    Optional<DataAnalyticModel> findByBrand(String brand);
}
