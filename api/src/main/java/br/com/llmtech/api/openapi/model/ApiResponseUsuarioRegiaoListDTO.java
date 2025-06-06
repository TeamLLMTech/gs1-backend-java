package br.com.llmtech.api.openapi.model;

import br.com.llmtech.api.dto.UsuarioRegiaoResponseDTO;
import br.com.llmtech.api.dto.common.ApiResponseWithPaginationDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Schema(name = "ApiResponseUsuarioRegiaoListDTO", description = "Resposta da API para uma lista de UsuarioRegiao")
public class ApiResponseUsuarioRegiaoListDTO extends ApiResponseWithPaginationDTO<List<UsuarioRegiaoResponseDTO>> {
}
