package com.lucas.feriasapi.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valorTotal;
    private LocalDate dataPagamento;
    private String statusPagamento; // Ex: PREVISTO, PAGO

    @OneToOne
    @JoinColumn(name = "ferias_id")
    private Ferias ferias;
}
