package com.lucas.feriasapi.dto;

import lombok.Data;
import java.util.List;

@Data
public class ServidorDTO {
    private Long id;
    private String nome;
    private String matricula;
    private String email;
    private List<FeriasDTO> listaFerias;
}
