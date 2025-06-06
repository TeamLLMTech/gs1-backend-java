package br.com.llmtech.api.openapi.model;

import br.com.llmtech.api.dto.TipoEventoNaturalResponseDTO;
import br.com.llmtech.api.dto.common.ApiResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "ApiResponseTipoEventoNaturalDTO", description = "Resposta da API para uma entidade TipoEventoNatural")
public class ApiResponseTipoEventoNaturalDTO extends ApiResponseDTO<TipoEventoNaturalResponseDTO> {
}
