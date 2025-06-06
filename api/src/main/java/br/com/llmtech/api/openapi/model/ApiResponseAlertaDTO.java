package br.com.llmtech.api.openapi.model;

import br.com.llmtech.api.dto.AlertaResponseDTO;
import br.com.llmtech.api.dto.common.ApiResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "ApiResponseAlertaDTO", description = "Resposta da API para uma entidade Alerta")
public class ApiResponseAlertaDTO extends ApiResponseDTO<AlertaResponseDTO> {
}
