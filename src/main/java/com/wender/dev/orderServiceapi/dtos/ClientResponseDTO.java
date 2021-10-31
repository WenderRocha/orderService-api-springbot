package com.wender.dev.orderServiceapi.dtos;

import com.wender.dev.orderServiceapi.entities.Client;
import com.wender.dev.orderServiceapi.entities.Technical;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class ClientResponseDTO implements Serializable {
    private Long id;
    private String name;

    public ClientResponseDTO(Client obj) {
        this.id = obj.getId();
        this.name = obj.getName();

    }
}


