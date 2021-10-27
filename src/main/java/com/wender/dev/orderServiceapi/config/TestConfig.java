package com.wender.dev.orderServiceapi.config;

import com.wender.dev.orderServiceapi.entities.Client;
import com.wender.dev.orderServiceapi.entities.OrderService;
import com.wender.dev.orderServiceapi.entities.Technical;
import com.wender.dev.orderServiceapi.entities.enums.OrderPriority;
import com.wender.dev.orderServiceapi.entities.enums.OrderStatus;
import com.wender.dev.orderServiceapi.repositories.ClientRepository;
import com.wender.dev.orderServiceapi.repositories.OrderServiceRepository;
import com.wender.dev.orderServiceapi.repositories.TechnicalRepository;
import com.wender.dev.orderServiceapi.services.TechnicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private TechnicalRepository technicalRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private OrderServiceRepository orderServiceRepository;

    @Override
    public void run(String... args) throws Exception {

        Technical t1 = new Technical(null, "Tomás Breno Peixoto", "360.008.321-09","(47) 98229-1358");
        Client c1 = new Client(null, "Lívia Rosângela Monteiro", "254.587.220-27", "(85) 98717-2694");
        OrderService os1 = new OrderService(null, "Teste create OS",OrderPriority.HIGHT , OrderStatus.PROGRESS,t1,c1);

        t1.getList().add(os1);
        c1.getList().add(os1);

        technicalRepository.saveAll(Arrays.asList(t1));
        clientRepository.saveAll(Arrays.asList(c1));
        orderServiceRepository.saveAll(Arrays.asList(os1));
    }
}
