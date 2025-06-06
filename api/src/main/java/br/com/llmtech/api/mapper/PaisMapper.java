package br.com.llmtech.api.mapper;

import br.com.llmtech.api.dto.PaisRequestDTO;
import br.com.llmtech.api.dto.PaisResponseDTO;
import br.com.llmtech.api.model.Pais;

public class PaisMapper {

    public static PaisResponseDTO toDTO(Pais pais) {
        PaisResponseDTO dto = new PaisResponseDTO();
        dto.setIdPais(pais.getIdPais());
        dto.setNome(pais.getNome());
        dto.setSigla(pais.getSigla());
        return dto;
    }

    public static Pais fromDTO(PaisRequestDTO dto) {
        Pais pais = new Pais();
        pais.setNome(dto.getNome());
        pais.setSigla(dto.getSigla());
        return pais;
    }

    public static void updateEntityUsingDTO(Pais pais, PaisRequestDTO dto) {
        pais.setNome(dto.getNome());
        pais.setSigla(dto.getSigla());
    }
}
