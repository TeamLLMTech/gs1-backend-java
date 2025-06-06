package br.com.llmtech.api.openapi.model;

import br.com.llmtech.api.dto.TipoEventoNaturalResponseDTO;
import br.com.llmtech.api.dto.common.ApiResponseWithPaginationDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Schema(name = "ApiResponseTipoEventoNaturalListDTO", description = "Resposta da API para uma lista de TipoEventoNatural")
public class ApiResponseTipoEventoNaturalListDTO extends ApiResponseWithPaginationDTO<List<TipoEventoNaturalResponseDTO>> {
}
