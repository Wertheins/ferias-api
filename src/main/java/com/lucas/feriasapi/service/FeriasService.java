package com.lucas.feriasapi.service;

import com.lucas.feriasapi.dto.FeriasDTO;
import com.lucas.feriasapi.dto.PagamentoDTO;
import com.lucas.feriasapi.model.Ferias;
import com.lucas.feriasapi.model.Servidor;
import com.lucas.feriasapi.repository.FeriasRepository;
import com.lucas.feriasapi.repository.ServidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeriasService {

    @Autowired
    private FeriasRepository feriasRepository;

    @Autowired
    private ServidorRepository servidorRepository;

    public List<FeriasDTO> buscarFeriasPorServidor(Long servidorId) {
        List<Ferias> ferias = feriasRepository.findByServidorId(servidorId);
        return ferias.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public FeriasDTO buscarPorId(Long id) {
        Ferias ferias = feriasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Férias não encontradas"));
        return convertToDTO(ferias);
    }

    public FeriasDTO criar(Long servidorId, Ferias ferias) {
        Servidor servidor = servidorRepository.findById(servidorId)
                .orElseThrow(() -> new RuntimeException("Servidor não encontrado"));
        
        ferias.setServidor(servidor);
        
        if (ferias.getPagamento() != null) {
            ferias.getPagamento().setFerias(ferias);
        }
        
        Ferias salvo = feriasRepository.save(ferias);
        return convertToDTO(salvo);
    }

    private FeriasDTO convertToDTO(Ferias ferias) {
        FeriasDTO dto = new FeriasDTO();
        dto.setId(ferias.getId());
        dto.setDataInicio(ferias.getDataInicio());
        dto.setDataFim(ferias.getDataFim());
        dto.setStatus(ferias.getStatus());
        
        if (ferias.getPagamento() != null) {
            PagamentoDTO pagDto = new PagamentoDTO();
            pagDto.setId(ferias.getPagamento().getId());
            pagDto.setValorTotal(ferias.getPagamento().getValorTotal());
            pagDto.setDataPagamento(ferias.getPagamento().getDataPagamento());
            pagDto.setStatusPagamento(ferias.getPagamento().getStatusPagamento());
            dto.setPagamento(pagDto);
        }
        
        return dto;
    }
}
