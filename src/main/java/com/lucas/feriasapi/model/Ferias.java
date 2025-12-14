package com.lucas.feriasapi.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Ferias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataInicio;
    private LocalDate dataFim;
    
    private String status; // Ex: SOLICITADO, APROVADO, USUFRUIDO

    @ManyToOne
    @JoinColumn(name = "servidor_id")
    private Servidor servidor;

    @OneToOne(mappedBy = "ferias", cascade = CascadeType.ALL)
    private Pagamento pagamento;
}
