package com.wender.dev.orderServiceapi.dtos;

import com.wender.dev.orderServiceapi.entities.Client;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ClientDTO implements Serializable {

    @EqualsAndHashCode.Include
    private Long id;

    @NotEmpty(message = "O campo NOME é requerido")
    private String name;

    @CPF
    @EqualsAndHashCode.Include
    @NotEmpty(message = "O campo CPF é requerido")
    private String cpf;

    @NotEmpty(message = "O campo TELEFONE é requerido")
    private String phone;

    public ClientDTO(Client obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.cpf = obj.getCpf();
        this.phone = obj.getPhone();

    }
}


