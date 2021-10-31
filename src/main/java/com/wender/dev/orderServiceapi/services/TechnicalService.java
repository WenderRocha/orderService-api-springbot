package com.wender.dev.orderServiceapi.services;

import com.wender.dev.orderServiceapi.dtos.TechnicalDTO;
import com.wender.dev.orderServiceapi.entities.Technical;
import com.wender.dev.orderServiceapi.repositories.TechnicalRepository;
import com.wender.dev.orderServiceapi.services.exceptions.DataIntegratyViolationException;
import com.wender.dev.orderServiceapi.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TechnicalService {

    @Autowired
    private TechnicalRepository repository;

    public Technical findById(Long id) {
        Optional<Technical> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " + id + ", Type: " + Technical.class.getName()));
    }

    public List<Technical> findAll() {
        return repository.findAll();
    }

    public Technical create(TechnicalDTO objDTO){
        if(findByCPF(objDTO) != null){
            throw new DataIntegratyViolationException("CPF já registrado na base de dados!");
        }
        return repository.save(new Technical(null, objDTO.getName(), objDTO.getCpf(), objDTO.getPhone()));
    }

    public Technical update(Long id, @Valid TechnicalDTO objDTO){
        Technical oldObj = findById(id);

        if(findByCPF(objDTO) != null && !Objects.equals(findByCPF(objDTO).getId(), id)){
            throw new DataIntegratyViolationException("CPF já registrado na base de dados!");
        }

        oldObj.setName(objDTO.getName());
        oldObj.setCpf(objDTO.getCpf());
        oldObj.setPhone(objDTO.getPhone());
        return repository.save(oldObj);
    }

    private Technical findByCPF(TechnicalDTO objDTO){
        return repository.findByCPF(objDTO.getCpf());
    }


}
