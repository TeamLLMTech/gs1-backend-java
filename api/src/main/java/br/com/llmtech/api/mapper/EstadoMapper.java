package br.com.llmtech.api.mapper;

import br.com.llmtech.api.dto.EstadoRequestDTO;
import br.com.llmtech.api.dto.EstadoResponseDTO;
import br.com.llmtech.api.model.Estado;
import br.com.llmtech.api.model.Pais;

public class EstadoMapper {

    public static EstadoResponseDTO toDTO(Estado estado) {
        EstadoResponseDTO dto = new EstadoResponseDTO();
        dto.setIdEstado(estado.getIdEstado());
        dto.setNome(estado.getNome());
        dto.setSigla(estado.getSigla());
        if (estado.getPais() != null) {
            dto.setIdPais(estado.getPais().getIdPais());
        }
        return dto;
    }

    public static Estado fromDTO(EstadoRequestDTO dto, Pais pais) {
        Estado estado = new Estado();
        estado.setNome(dto.getNome());
        estado.setSigla(dto.getSigla());
        estado.setPais(pais);
        return estado;
    }

    public static void updateEntityUsingDTO(Estado estado, EstadoRequestDTO dto, Pais pais) {
        estado.setNome(dto.getNome());
        estado.setSigla(dto.getSigla());
        estado.setPais(pais);
    }
}
