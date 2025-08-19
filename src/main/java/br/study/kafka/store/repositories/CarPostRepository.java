package br.study.kafka.store.repositories;

import br.study.kafka.store.dto.CarPostDTO;
import br.study.kafka.store.models.CarPostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarPostRepository extends JpaRepository<CarPostModel, Long> {
}
