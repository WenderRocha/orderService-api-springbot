package com.wender.dev.orderServiceapi.repositories;

import com.wender.dev.orderServiceapi.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
