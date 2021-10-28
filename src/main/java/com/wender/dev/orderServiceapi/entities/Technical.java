package com.wender.dev.orderServiceapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Technical extends Person implements Serializable {

    @JsonIgnore
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "technical")
    private List<OrderService> list = new ArrayList<>();

    public Technical(Long id, String name, String cpf, String phone) {
        super(id, name, cpf, phone);
    }
}
