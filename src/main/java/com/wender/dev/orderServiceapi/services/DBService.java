package com.wender.dev.orderServiceapi.services;

import com.wender.dev.orderServiceapi.entities.Client;
import com.wender.dev.orderServiceapi.entities.OrderService;
import com.wender.dev.orderServiceapi.entities.Technical;
import com.wender.dev.orderServiceapi.entities.enums.OrderPriority;
import com.wender.dev.orderServiceapi.entities.enums.OrderStatus;
import com.wender.dev.orderServiceapi.repositories.ClientRepository;
import com.wender.dev.orderServiceapi.repositories.OrderServiceRepository;
import com.wender.dev.orderServiceapi.repositories.TechnicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    private TechnicalRepository technicalRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private OrderServiceRepository orderServiceRepository;

    public void getInstaceDB() {

        Technical t1 = new Technical(null, "Tomás Breno Peixoto", "360.008.321-09", "(47) 98229-1358");
        Client c1 = new Client(null, "Lívia Rosângela Monteiro", "254.587.220-27", "(85) 98717-2694");
        OrderService os1 = new OrderService(null, "Teste create OS", OrderPriority.HIGHT, OrderStatus.PROGRESS, t1, c1);

        t1.getList().add(os1);
        c1.getList().add(os1);

        technicalRepository.saveAll(Arrays.asList(t1));
        clientRepository.saveAll(Arrays.asList(c1));
        orderServiceRepository.saveAll(Arrays.asList(os1));
    }
}
