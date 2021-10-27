package com.wender.dev.orderServiceapi.entities;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Technical extends Person{
    public Technical(Long id, String name, String cpf, String phone) {
        super(id, name, cpf, phone);
    }
}
