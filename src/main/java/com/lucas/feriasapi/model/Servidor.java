package com.lucas.feriasapi.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Servidor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private String matricula;
    private String email;

    @OneToMany(mappedBy = "servidor", cascade = CascadeType.ALL)
    private List<Ferias> listaFerias;
}
