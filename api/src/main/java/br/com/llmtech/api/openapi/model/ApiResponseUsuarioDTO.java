package br.com.llmtech.api.openapi.model;

import br.com.llmtech.api.dto.UsuarioResponseDTO;
import br.com.llmtech.api.dto.common.ApiResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "ApiResponseUsuarioDTO", description = "Resposta da API para uma entidade Usuario")
public class ApiResponseUsuarioDTO extends ApiResponseDTO<UsuarioResponseDTO> {
}
