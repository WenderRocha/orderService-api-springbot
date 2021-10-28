package com.wender.dev.orderServiceapi.resources;

import com.wender.dev.orderServiceapi.dtos.TechnicalDTO;
import com.wender.dev.orderServiceapi.services.TechnicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/technicals")
public class TechnicalResource {

    @Autowired
    private TechnicalService service;

    @GetMapping
    public ResponseEntity<List<TechnicalDTO>> findAll() {
        List<TechnicalDTO> listDTO = service.findAll().stream().map(obj -> new TechnicalDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TechnicalDTO> findById(@PathVariable Long id) {
        TechnicalDTO objDTO = new TechnicalDTO(service.findById(id));
        return ResponseEntity.ok().body(objDTO);
    }
}
