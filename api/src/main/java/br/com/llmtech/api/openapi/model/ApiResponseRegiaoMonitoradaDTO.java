package br.com.llmtech.api.openapi.model;

import br.com.llmtech.api.dto.RegiaoMonitoradaResponseDTO;
import br.com.llmtech.api.dto.common.ApiResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "ApiResponseRegiaoMonitoradaDTO", description = "Resposta da API para uma entidade RegiaoMonitorada")
public class ApiResponseRegiaoMonitoradaDTO extends ApiResponseDTO<RegiaoMonitoradaResponseDTO> {
}
