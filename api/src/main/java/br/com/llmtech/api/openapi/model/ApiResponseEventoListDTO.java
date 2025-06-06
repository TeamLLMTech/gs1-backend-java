package br.com.llmtech.api.openapi.model;

import br.com.llmtech.api.dto.EventoResponseDTO;
import br.com.llmtech.api.dto.common.ApiResponseWithPaginationDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Schema(name = "ApiResponseEventoListDTO", description = "Resposta da API para uma lista de Eventos")
public class ApiResponseEventoListDTO extends ApiResponseWithPaginationDTO<List<EventoResponseDTO>> {
}
