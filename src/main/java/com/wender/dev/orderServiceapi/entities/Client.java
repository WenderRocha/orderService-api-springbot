package com.wender.dev.orderServiceapi.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Client extends Person implements Serializable {

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "client")
    private List<OrderService> list = new ArrayList<>();

    public Client(Long id, String name, String cpf, String phone) {
        super(id, name, cpf, phone);
    }
}
