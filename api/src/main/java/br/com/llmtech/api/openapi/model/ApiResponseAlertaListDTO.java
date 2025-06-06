package br.com.llmtech.api.openapi.model;

import br.com.llmtech.api.dto.AlertaResponseDTO;
import br.com.llmtech.api.dto.common.ApiResponseWithPaginationDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Schema(name = "ApiResponseAlertaListDTO", description = "Resposta da API para uma lista de Alertas")
public class ApiResponseAlertaListDTO extends ApiResponseWithPaginationDTO<List<AlertaResponseDTO>> {
}
