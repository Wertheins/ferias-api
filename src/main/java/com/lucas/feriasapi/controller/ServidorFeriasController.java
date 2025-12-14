package com.lucas.feriasapi.controller;

import com.lucas.feriasapi.dto.FeriasDTO;
import com.lucas.feriasapi.model.Ferias;
import com.lucas.feriasapi.service.FeriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servidores/{servidorId}/ferias")
public class ServidorFeriasController {

    @Autowired
    private FeriasService feriasService;

    @GetMapping
    public ResponseEntity<Page<FeriasDTO>> listarFeriasPorServidor(
            @PathVariable Long servidorId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(feriasService.buscarFeriasPorServidor(servidorId, pageable));
    }

    @PostMapping
    public ResponseEntity<FeriasDTO> criarFerias(@PathVariable Long servidorId, @RequestBody Ferias ferias) {
        return ResponseEntity.ok(feriasService.criar(servidorId, ferias));
    }
}
