package br.com.llmtech.api.openapi.model;

import br.com.llmtech.api.dto.ModeloIAResponseDTO;
import br.com.llmtech.api.dto.common.ApiResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "ApiResponseModeloIADTO", description = "Resposta da API para uma entidade ModeloIA")
public class ApiResponseModeloIADTO extends ApiResponseDTO<ModeloIAResponseDTO> {
}
