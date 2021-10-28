package com.wender.dev.orderServiceapi.services;

import com.wender.dev.orderServiceapi.entities.Technical;
import com.wender.dev.orderServiceapi.repositories.TechnicalRepository;
import com.wender.dev.orderServiceapi.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TechnicalService {

    @Autowired
    private TechnicalRepository repository;

    public Technical findById(Long id){
        Optional<Technical> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " + id + ", Type: " + Technical.class.getName()));
    }
}
