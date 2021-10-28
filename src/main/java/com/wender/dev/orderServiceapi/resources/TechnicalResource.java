package com.wender.dev.orderServiceapi.resources;

import com.wender.dev.orderServiceapi.entities.Technical;
import com.wender.dev.orderServiceapi.services.TechnicalService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/technicals")
public class TechnicalResource {

    @Autowired
    private TechnicalService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Technical> findById(@PathVariable Long id){
        Technical obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}