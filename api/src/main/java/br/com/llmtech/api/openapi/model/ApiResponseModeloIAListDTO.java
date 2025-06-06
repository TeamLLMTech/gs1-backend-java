package br.com.llmtech.api.openapi.model;

import br.com.llmtech.api.dto.ModeloIAResponseDTO;
import br.com.llmtech.api.dto.common.ApiResponseWithPaginationDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Schema(name = "ApiResponseModeloIAListDTO", description = "Resposta da API para uma lista de ModeloIA")
public class ApiResponseModeloIAListDTO extends ApiResponseWithPaginationDTO<List<ModeloIAResponseDTO>> {
}
