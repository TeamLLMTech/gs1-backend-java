package br.com.llmtech.api.mapper;

import br.com.llmtech.api.dto.AlertaRequestDTO;
import br.com.llmtech.api.dto.AlertaResponseDTO;
import br.com.llmtech.api.model.Alerta;
import br.com.llmtech.api.model.Evento;

public class AlertaMapper {
    public static AlertaResponseDTO toDTO(Alerta alerta) {
        AlertaResponseDTO dto = new AlertaResponseDTO();
        dto.setIdAlerta(alerta.getIdAlerta());
        dto.setNivelAlerta(alerta.getNivelAlerta());
        dto.setMensagemAlerta(alerta.getMensagemAlerta());
        dto.setDataEmissao(alerta.getDataEmissao());
        if (alerta.getEvento() != null) {
            dto.setIdEvento(alerta.getEvento().getIdEvento());
        }
        return dto;
    }

    public static Alerta fromDTO(AlertaRequestDTO dto, Evento evento) {
        Alerta alerta = new Alerta();
        alerta.setNivelAlerta(dto.getNivelAlerta());
        alerta.setMensagemAlerta(dto.getMensagemAlerta());
        alerta.setDataEmissao(dto.getDataEmissao());
        alerta.setEvento(evento);
        return alerta;
    }

    public static void updateEntityUsingDTO(Alerta alerta, AlertaRequestDTO dto, Evento evento) {
        alerta.setNivelAlerta(dto.getNivelAlerta());
        alerta.setMensagemAlerta(dto.getMensagemAlerta());
        alerta.setDataEmissao(dto.getDataEmissao());
        alerta.setEvento(evento);
    }
}
