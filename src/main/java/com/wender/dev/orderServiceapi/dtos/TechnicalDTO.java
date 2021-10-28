package com.wender.dev.orderServiceapi.dtos;

import com.wender.dev.orderServiceapi.entities.Technical;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class TechnicalDTO implements Serializable {
    private Long id;
    private String name;
    private String phone;

    public TechnicalDTO(Technical obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.phone = obj.getPhone();
    }
}


