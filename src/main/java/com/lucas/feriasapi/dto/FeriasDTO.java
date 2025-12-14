package com.lucas.feriasapi.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class FeriasDTO {
    private Long id;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String status;
    private PagamentoDTO pagamento;
}
