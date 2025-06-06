package br.com.llmtech.api.mapper;

import br.com.llmtech.api.dto.ModeloIARequestDTO;
import br.com.llmtech.api.dto.ModeloIAResponseDTO;
import br.com.llmtech.api.model.ModeloIA;

public class ModeloIAMapper {
    public static ModeloIAResponseDTO toDTO(ModeloIA modelo) {
        ModeloIAResponseDTO dto = new ModeloIAResponseDTO();
        dto.setIdModelo(modelo.getIdModelo());
        dto.setNomeModelo(modelo.getNomeModelo());
        dto.setTipoModelo(modelo.getTipoModelo());
        dto.setAlgoritmoBase(modelo.getAlgoritmoBase());
        dto.setDataTreinamento(modelo.getDataTreinamento());
        dto.setAcuracia(modelo.getAcuracia());
        dto.setDescricaoModelo(modelo.getDescricaoModelo());
        return dto;
    }

    public static ModeloIA fromDTO(ModeloIARequestDTO dto) {
        ModeloIA modelo = new ModeloIA();
        modelo.setNomeModelo(dto.getNomeModelo());
        modelo.setTipoModelo(dto.getTipoModelo());
        modelo.setAlgoritmoBase(dto.getAlgoritmoBase());
        modelo.setDataTreinamento(dto.getDataTreinamento());
        modelo.setAcuracia(dto.getAcuracia());
        modelo.setDescricaoModelo(dto.getDescricaoModelo());
        return modelo;
    }

    public static void updateEntityUsingDTO(ModeloIA modelo, ModeloIARequestDTO dto) {
        modelo.setNomeModelo(dto.getNomeModelo());
        modelo.setTipoModelo(dto.getTipoModelo());
        modelo.setAlgoritmoBase(dto.getAlgoritmoBase());
        modelo.setDataTreinamento(dto.getDataTreinamento());
        modelo.setAcuracia(dto.getAcuracia());
        modelo.setDescricaoModelo(dto.getDescricaoModelo());
    }
}
