package com.wender.dev.orderServiceapi.resources;

import com.wender.dev.orderServiceapi.dtos.TechnicalDTO;
import com.wender.dev.orderServiceapi.dtos.TechnicalResponseDTO;
import com.wender.dev.orderServiceapi.entities.Technical;
import com.wender.dev.orderServiceapi.services.TechnicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/technicals")
public class TechnicalResource {

    @Autowired
    private TechnicalService service;

    @GetMapping
    public ResponseEntity<List<TechnicalResponseDTO>> findAll() {
        //List<Technical> list = service.findAll();

        //start method 1
        //List<TechnicalDTO> listDTO = new ArrayList<>();
        //for(Technical obj : list){
        //listDTO.add(new TechnicalDTO(obj));
        //}
        //end method 1

        //start cod 1 : resume method 1
        //list.forEach(obj -> listDTO.add(new TechnicalDTO(obj)));
        //end cod 1 : resume method 1

        //start cod 2 : resume method 1 and cod 1
        List<TechnicalResponseDTO> listDTO = service.findAll()
                .stream().map(obj -> new TechnicalResponseDTO(obj))
                .collect(Collectors.toList());
        //end cod 2 : resume method 1 and cod 1

        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TechnicalResponseDTO> findById(@PathVariable Long id) {
        TechnicalResponseDTO objDTO = new TechnicalResponseDTO(service.findById(id));
        return ResponseEntity.ok().body(objDTO);
    }

    @PostMapping
    public ResponseEntity<TechnicalDTO> create(@RequestBody TechnicalDTO objDTO) {
        Technical newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
