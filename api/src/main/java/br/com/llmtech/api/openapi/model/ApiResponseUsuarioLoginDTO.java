package br.com.llmtech.api.openapi.model;

import br.com.llmtech.api.dto.UsuarioLoginResponseDTO;
import br.com.llmtech.api.dto.UsuarioResponseDTO;
import br.com.llmtech.api.dto.common.ApiResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "ApiResponseUsuarioLoginDTO", description = "Resposta da API para um login")
public class ApiResponseUsuarioLoginDTO extends ApiResponseDTO<UsuarioLoginResponseDTO> {
}
