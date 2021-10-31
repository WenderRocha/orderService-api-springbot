package com.wender.dev.orderServiceapi.repositories;

import com.wender.dev.orderServiceapi.entities.Person;
import com.wender.dev.orderServiceapi.entities.Technical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query("SELECT obj FROM Person obj WHERE obj.cpf = :cpf")
    Person findByCPF(@Param("cpf") String cpf);
}
