package com.wender.dev.orderServiceapi.repositories;

import com.wender.dev.orderServiceapi.entities.Technical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicalRepository extends JpaRepository<Technical, Long> {

    @Query("SELECT obj FROM Technical obj WHERE obj.cpf = :cpf")
    Technical findByCPF(@Param("cpf") String cpf);
}
