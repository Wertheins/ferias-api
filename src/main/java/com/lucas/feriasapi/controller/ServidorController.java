package com.lucas.feriasapi.controller;

import com.lucas.feriasapi.dto.ServidorDTO;
import com.lucas.feriasapi.model.Servidor;
import com.lucas.feriasapi.service.ServidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servidores")
public class ServidorController {

    @Autowired
    private ServidorService servidorService;

    @GetMapping
    public ResponseEntity<List<ServidorDTO>> listarTodos() {
        return ResponseEntity.ok(servidorService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServidorDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(servidorService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ServidorDTO> criar(@RequestBody Servidor servidor) {
        return ResponseEntity.ok(servidorService.criar(servidor));
    }
}
