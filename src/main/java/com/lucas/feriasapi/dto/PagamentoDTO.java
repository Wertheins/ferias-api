package com.lucas.feriasapi.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class PagamentoDTO {
    private Long id;
    private BigDecimal valorTotal;
    private LocalDate dataPagamento;
    private String statusPagamento;
}
