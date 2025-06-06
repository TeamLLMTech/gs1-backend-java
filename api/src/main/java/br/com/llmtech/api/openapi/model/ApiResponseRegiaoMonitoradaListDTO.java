package br.com.llmtech.api.openapi.model;

import br.com.llmtech.api.dto.RegiaoMonitoradaResponseDTO;
import br.com.llmtech.api.dto.common.ApiResponseWithPaginationDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Schema(name = "ApiResponseRegiaoMonitoradaListDTO", description = "Resposta da API para uma lista de RegiaoMonitorada")
public class ApiResponseRegiaoMonitoradaListDTO extends ApiResponseWithPaginationDTO<List<RegiaoMonitoradaResponseDTO>> {
}
