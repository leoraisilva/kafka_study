package br.study.kafka.store.repositories;

import br.study.kafka.store.models.OwnerPostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerPostRepository extends JpaRepository<OwnerPostModel, Long> {
}
