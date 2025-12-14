package com.lucas.feriasapi.controller;

import com.lucas.feriasapi.dto.CriarServidorDTO;
import com.lucas.feriasapi.dto.ServidorDTO;
import com.lucas.feriasapi.model.Servidor;
import com.lucas.feriasapi.service.ServidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servidores")
public class ServidorController {

    @Autowired
    private ServidorService servidorService;

    @GetMapping
    public ResponseEntity<Page<ServidorDTO>> listarTodos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(servidorService.listarTodos(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServidorDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(servidorService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ServidorDTO> criar(@RequestBody CriarServidorDTO dto) {
        return ResponseEntity.ok(servidorService.criar(dto));
    }
}
