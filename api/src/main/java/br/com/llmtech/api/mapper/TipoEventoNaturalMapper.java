package br.com.llmtech.api.mapper;

import br.com.llmtech.api.dto.TipoEventoNaturalRequestDTO;
import br.com.llmtech.api.dto.TipoEventoNaturalResponseDTO;
import br.com.llmtech.api.model.TipoEventoNatural;

public class TipoEventoNaturalMapper {
    public static TipoEventoNaturalResponseDTO toDTO(TipoEventoNatural tipo) {
        TipoEventoNaturalResponseDTO dto = new TipoEventoNaturalResponseDTO();
        dto.setIdTipoEvento(tipo.getIdTipoEvento());
        dto.setTipoEvento(tipo.getTipoEvento());
        dto.setDescricao(tipo.getDescricao());
        dto.setIntensidadeEvento(tipo.getIntensidadeEvento());
        return dto;
    }

    public static TipoEventoNatural fromDTO(TipoEventoNaturalRequestDTO dto) {
        TipoEventoNatural tipo = new TipoEventoNatural();
        tipo.setTipoEvento(dto.getTipoEvento());
        tipo.setDescricao(dto.getDescricao());
        tipo.setIntensidadeEvento(dto.getIntensidadeEvento());
        return tipo;
    }

    public static void updateEntityUsingDTO(TipoEventoNatural tipo, TipoEventoNaturalRequestDTO dto) {
        tipo.setTipoEvento(dto.getTipoEvento());
        tipo.setDescricao(dto.getDescricao());
        tipo.setIntensidadeEvento(dto.getIntensidadeEvento());
    }
}
