package br.com.llmtech.api.mapper;

import br.com.llmtech.api.dto.RegiaoMonitoradaRequestDTO;
import br.com.llmtech.api.dto.RegiaoMonitoradaResponseDTO;
import br.com.llmtech.api.model.RegiaoMonitorada;
import br.com.llmtech.api.model.Municipio;

public class RegiaoMonitoradaMapper {
    public static RegiaoMonitoradaResponseDTO toDTO(RegiaoMonitorada regiao) {
        RegiaoMonitoradaResponseDTO dto = new RegiaoMonitoradaResponseDTO();
        dto.setIdRegiao(regiao.getIdRegiao());
        dto.setNomeRegiao(regiao.getNomeRegiao());
        dto.setTipoZona(regiao.getTipoZona());
        dto.setPopulacaoEstimada(regiao.getPopulacaoEstimada());
        dto.setDescriacaoArea(regiao.getDescriacaoArea());
        if (regiao.getMunicipio() != null) {
            dto.setIdMunicipio(regiao.getMunicipio().getIdMunicipio());
        }
        return dto;
    }

    public static RegiaoMonitorada fromDTO(RegiaoMonitoradaRequestDTO dto, Municipio municipio) {
        RegiaoMonitorada regiao = new RegiaoMonitorada();
        regiao.setNomeRegiao(dto.getNomeRegiao());
        regiao.setTipoZona(dto.getTipoZona());
        regiao.setPopulacaoEstimada(dto.getPopulacaoEstimada());
        regiao.setDescriacaoArea(dto.getDescriacaoArea());
        regiao.setMunicipio(municipio);
        return regiao;
    }

    public static void updateEntityUsingDTO(RegiaoMonitorada regiao, RegiaoMonitoradaRequestDTO dto, Municipio municipio) {
        regiao.setNomeRegiao(dto.getNomeRegiao());
        regiao.setTipoZona(dto.getTipoZona());
        regiao.setPopulacaoEstimada(dto.getPopulacaoEstimada());
        regiao.setDescriacaoArea(dto.getDescriacaoArea());
        regiao.setMunicipio(municipio);
    }
}
