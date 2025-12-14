package com.lucas.feriasapi.controller;

import com.lucas.feriasapi.dto.FeriasDTO;
import com.lucas.feriasapi.model.Ferias;
import com.lucas.feriasapi.service.FeriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servidores/{servidorId}/ferias")
public class ServidorFeriasController {

    @Autowired
    private FeriasService feriasService;

    @GetMapping
    public ResponseEntity<List<FeriasDTO>> listarFeriasPorServidor(@PathVariable Long servidorId) {
        return ResponseEntity.ok(feriasService.buscarFeriasPorServidor(servidorId));
    }

    @PostMapping
    public ResponseEntity<FeriasDTO> criarFerias(@PathVariable Long servidorId, @RequestBody Ferias ferias) {
        return ResponseEntity.ok(feriasService.criar(servidorId, ferias));
    }
}
