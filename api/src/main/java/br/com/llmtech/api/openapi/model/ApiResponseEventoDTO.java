package br.com.llmtech.api.openapi.model;

import br.com.llmtech.api.dto.EventoResponseDTO;
import br.com.llmtech.api.dto.common.ApiResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "ApiResponseEventoDTO", description = "Resposta da API para uma entidade Evento")
public class ApiResponseEventoDTO extends ApiResponseDTO<EventoResponseDTO> {
}
