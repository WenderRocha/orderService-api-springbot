package com.wender.dev.orderServiceapi.resources;

import com.wender.dev.orderServiceapi.dtos.ClientDTO;
import com.wender.dev.orderServiceapi.dtos.ClientResponseDTO;
import com.wender.dev.orderServiceapi.entities.Client;
import com.wender.dev.orderServiceapi.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

    @Autowired
    private ClientService service;

    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> findAll() {
        //List<Client> list = service.findAll();

        //start method 1
        //List<ClientDTO> listDTO = new ArrayList<>();
        //for(Client obj : list){
        //listDTO.add(new ClientDTO(obj));
        //}
        //end method 1

        //start cod 1 : resume method 1
        //list.forEach(obj -> listDTO.add(new ClientDTO(obj)));
        //end cod 1 : resume method 1

        //start cod 2 : resume method 1 and cod 1
        List<ClientResponseDTO> listDTO = service.findAll()
                .stream().map(obj -> new ClientResponseDTO(obj))
                .collect(Collectors.toList());
        //end cod 2 : resume method 1 and cod 1

        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientResponseDTO> findById(@PathVariable Long id) {
        ClientResponseDTO objDTO = new ClientResponseDTO(service.findById(id));
        return ResponseEntity.ok().body(objDTO);
    }

    @PostMapping
    public ResponseEntity<ClientDTO> create(@Valid @RequestBody ClientDTO objDTO) {
        Client newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(newObj
                        .getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> update(@Valid @PathVariable Long id, @Valid @RequestBody ClientDTO objDTO) {
        ClientDTO newObj = new ClientDTO(service.update(id, objDTO));
        return ResponseEntity.ok().body(newObj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
