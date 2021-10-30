package com.wender.dev.orderServiceapi.dtos;

import com.wender.dev.orderServiceapi.entities.Technical;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class TechnicalResponseDTO implements Serializable {
    private Long id;
    private String name;

    public TechnicalResponseDTO(Technical obj) {
        this.id = obj.getId();
        this.name = obj.getName();

    }
}


