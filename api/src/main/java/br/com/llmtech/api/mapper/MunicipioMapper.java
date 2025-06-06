package br.com.llmtech.api.mapper;

import br.com.llmtech.api.dto.MunicipioRequestDTO;
import br.com.llmtech.api.dto.MunicipioResponseDTO;
import br.com.llmtech.api.model.Estado;
import br.com.llmtech.api.model.Municipio;

public class MunicipioMapper {

    public static MunicipioResponseDTO toDTO(Municipio municipio) {
        MunicipioResponseDTO dto = new MunicipioResponseDTO();
        dto.setIdMunicipio(municipio.getIdMunicipio());
        dto.setNome(municipio.getNome());
        if (municipio.getEstado() != null) {
            dto.setIdEstado(municipio.getEstado().getIdEstado());
        }
        return dto;
    }

    public static Municipio fromDTO(MunicipioRequestDTO dto, Estado estado) {
        Municipio municipio = new Municipio();
        municipio.setNome(dto.getNome());
        municipio.setEstado(estado);
        return municipio;
    }

    public static void updateEntityUsingDTO(Municipio municipio, MunicipioRequestDTO dto, Estado estado) {
        municipio.setNome(dto.getNome());
        municipio.setEstado(estado);
    }
}
