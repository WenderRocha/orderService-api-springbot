package com.wender.dev.orderServiceapi.entities;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class Person {

    @EqualsAndHashCode.Include
    private Long id;
    private String name;
    @EqualsAndHashCode.Include
    private String cpf;
    private String phone;
}
