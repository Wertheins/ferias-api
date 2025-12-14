package com.lucas.feriasapi.service;

import com.lucas.feriasapi.dto.ServidorDTO;
import com.lucas.feriasapi.dto.FeriasDTO;
import com.lucas.feriasapi.dto.PagamentoDTO;
import com.lucas.feriasapi.model.Servidor;
import com.lucas.feriasapi.model.Ferias;
import com.lucas.feriasapi.repository.ServidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServidorService {

    @Autowired
    private ServidorRepository servidorRepository;

    public Page<ServidorDTO> listarTodos(Pageable pageable) {
        return servidorRepository.findAll(pageable)
                .map(this::convertToDTO);
    }

    public ServidorDTO buscarPorId(Long id) {
        Servidor servidor = servidorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Servidor não encontrado"));
        return convertToDTO(servidor);
    }

    public ServidorDTO criar(Servidor servidor) {
        Servidor salvo = servidorRepository.save(servidor);
        return convertToDTO(salvo);
    }

    private ServidorDTO convertToDTO(Servidor servidor) {
        ServidorDTO dto = new ServidorDTO();
        dto.setId(servidor.getId());
        dto.setNome(servidor.getNome());
        dto.setMatricula(servidor.getMatricula());
        dto.setEmail(servidor.getEmail());
        
        if (servidor.getListaFerias() != null) {
            dto.setListaFerias(servidor.getListaFerias().stream()
                    .map(this::convertFeriasToDTO)
                    .collect(Collectors.toList()));
        }
        
        return dto;
    }

    private FeriasDTO convertFeriasToDTO(Ferias ferias) {
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
