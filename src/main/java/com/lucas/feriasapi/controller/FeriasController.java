package com.lucas.feriasapi.controller;

import com.lucas.feriasapi.dto.FeriasDTO;
import com.lucas.feriasapi.service.FeriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ferias")
public class FeriasController {

    @Autowired
    private FeriasService feriasService;

    @GetMapping("/{id}")
    public ResponseEntity<FeriasDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(feriasService.buscarPorId(id));
    }
}
