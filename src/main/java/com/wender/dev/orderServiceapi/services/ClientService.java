package com.wender.dev.orderServiceapi.services;

import com.wender.dev.orderServiceapi.dtos.ClientDTO;
import com.wender.dev.orderServiceapi.entities.Person;
import com.wender.dev.orderServiceapi.entities.Client;
import com.wender.dev.orderServiceapi.repositories.PersonRepository;
import com.wender.dev.orderServiceapi.repositories.ClientRepository;
import com.wender.dev.orderServiceapi.services.exceptions.DataIntegratyViolationException;
import com.wender.dev.orderServiceapi.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Autowired
    private PersonRepository personRepository;

    public Client findById(Long id) {
        Optional<Client> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " + id));
    }

    public List<Client> findAll() {
        return repository.findAll();
    }

    public Client create(ClientDTO objDTO) {
        if (findByCPF(objDTO) != null) {
            throw new DataIntegratyViolationException("CPF já registrado na base de dados!");
        }
        return repository.save(new Client(null, objDTO.getName(), objDTO.getCpf(), objDTO.getPhone()));
    }

    public Client update(Long id, @Valid ClientDTO objDTO) {
        Client oldObj = findById(id);

        if (findByCPF(objDTO) != null && !Objects.equals(findByCPF(objDTO).getId(), id)) {
            throw new DataIntegratyViolationException("CPF já registrado na base de dados!");
        }

        oldObj.setName(objDTO.getName());
        oldObj.setCpf(objDTO.getCpf());
        oldObj.setPhone(objDTO.getPhone());
        return repository.save(oldObj);
    }

    public void delete(Long id) {
        Client obj = findById(id);
        if (obj.getList().size() > 0) {
            throw new DataIntegratyViolationException("Pessoa possui Ordens de Serviço, não pode ser deletado!");
        }
        repository.deleteById(id);
    }

    private Person findByCPF(ClientDTO objDTO) {
        return personRepository.findByCPF(objDTO.getCpf());
    }

}
