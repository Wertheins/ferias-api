package com.lucas.feriasapi.repository;

import com.lucas.feriasapi.model.Ferias;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FeriasRepository extends JpaRepository<Ferias, Long> {
    List<Ferias> findByServidorId(Long servidorId);
}
