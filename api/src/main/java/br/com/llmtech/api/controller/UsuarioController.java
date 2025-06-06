package br.com.llmtech.api.controller;

import br.com.llmtech.api.dto.UsuarioRequestDTO;
import br.com.llmtech.api.dto.UsuarioResponseDTO;
import br.com.llmtech.api.dto.common.ApiErrorDTO;
import br.com.llmtech.api.dto.common.ApiResponseDTO;
import br.com.llmtech.api.openapi.model.ApiResponseUsuarioDTO;
import br.com.llmtech.api.openapi.model.ApiResponseUsuarioListDTO;
import br.com.llmtech.api.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@Tag(name = "usuarios", description = "CRUD de Usuários")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Operation(summary = "Cria um novo usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiResponseUsuarioDTO.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class))),
            @ApiResponse(responseCode = "422", description = "Parâmetros informados não atendem aos requisitos esperados", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class)))
    })
    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> create(@Valid @RequestBody UsuarioRequestDTO dto) {
        UsuarioResponseDTO response = usuarioService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(
            summary = "Lista todos os usuários",
            parameters = {
                    @Parameter(name = "page", description = "Número da página (0..N)", example = "0"),
                    @Parameter(name = "size", description = "Quantidade de elementos por página", example = "10"),
                    @Parameter(name = "sort", description = "Critério de ordenação no formato: propriedade[,asc|desc].")
            }
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listagem de usuários bem-sucedida", content = @Content(schema = @Schema(implementation = ApiResponseUsuarioListDTO.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class)))
    })
    @GetMapping
    public ResponseEntity<ApiResponseDTO<List<UsuarioResponseDTO>>> findAll(@PageableDefault Pageable pageable) {
        Page<UsuarioResponseDTO> page = usuarioService.findAll(pageable);
        ApiResponseDTO<List<UsuarioResponseDTO>> response = new ApiResponseDTO<>(page.getContent());
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Busca usuário por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário encontrado", content = @Content(schema = @Schema(implementation = ApiResponseUsuarioDTO.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class))),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado para o ID fornecido", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class)))
    })
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> findById(@PathVariable Long id) {
        UsuarioResponseDTO response = usuarioService.findById(id);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Atualiza um usuário existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiResponseUsuarioDTO.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class))),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado para o ID fornecido", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class))),
            @ApiResponse(responseCode = "422", description = "Parâmetros informados não atendem aos requisitos esperados", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class)))
    })
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> update(@PathVariable Long id, @Valid @RequestBody UsuarioRequestDTO dto) {
        UsuarioResponseDTO response = usuarioService.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Remove um usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Usuário removido com sucesso"),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class))),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado para o ID fornecido", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
