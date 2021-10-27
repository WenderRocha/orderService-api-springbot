package com.wender.dev.orderServiceapi.entities;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Client extends Person{
    public Client(Long id, String name, String cpf, String phone) {
        super(id, name, cpf, phone);
    }
}
