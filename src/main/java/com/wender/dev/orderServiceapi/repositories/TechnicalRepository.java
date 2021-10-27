package com.wender.dev.orderServiceapi.repositories;

import com.wender.dev.orderServiceapi.entities.Technical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicalRepository extends JpaRepository<Technical, Long> {
}
