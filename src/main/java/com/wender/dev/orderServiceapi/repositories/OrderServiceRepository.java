package com.wender.dev.orderServiceapi.repositories;

import com.wender.dev.orderServiceapi.entities.OrderService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderServiceRepository extends JpaRepository<OrderService, Long> {
}
