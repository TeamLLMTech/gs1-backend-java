package br.com.llmtech.api.openapi.model;

import br.com.llmtech.api.dto.UsuarioRegiaoResponseDTO;
import br.com.llmtech.api.dto.common.ApiResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "ApiResponseUsuarioRegiaoDTO", description = "Resposta da API para uma entidade UsuarioRegiao")
public class ApiResponseUsuarioRegiaoDTO extends ApiResponseDTO<UsuarioRegiaoResponseDTO> {
}
