package com.lucas.feriasapi.repository;

import com.lucas.feriasapi.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
