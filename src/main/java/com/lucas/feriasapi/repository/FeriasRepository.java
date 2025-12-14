package com.lucas.feriasapi.repository;

import com.lucas.feriasapi.model.Ferias;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeriasRepository extends JpaRepository<Ferias, Long> {
    Page<Ferias> findByServidorId(Long servidorId, Pageable pageable);
}
