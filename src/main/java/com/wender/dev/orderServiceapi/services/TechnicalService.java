package com.wender.dev.orderServiceapi.services;

import com.wender.dev.orderServiceapi.repositories.TechnicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TechnicalService {

    @Autowired
    private TechnicalRepository repository;
}
