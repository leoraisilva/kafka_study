package br.study.kafka.analitic.repositories;

import br.study.kafka.analitic.models.CarAnalyticPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarAnalyticPriceRepository extends JpaRepository<CarAnalyticPrice, Long> {
    Optional<CarAnalyticPrice> findByPrice(Double price);
}
