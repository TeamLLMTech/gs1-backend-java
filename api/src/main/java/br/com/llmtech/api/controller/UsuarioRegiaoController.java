package br.com.llmtech.api.controller;

import br.com.llmtech.api.dto.TipoEventoNaturalResponseDTO;
import br.com.llmtech.api.dto.UsuarioRegiaoRequestDTO;
import br.com.llmtech.api.dto.UsuarioRegiaoResponseDTO;
import br.com.llmtech.api.dto.common.ApiErrorDTO;
import br.com.llmtech.api.dto.common.ApiResponseDTO;
import br.com.llmtech.api.openapi.model.ApiResponseUsuarioRegiaoDTO;
import br.com.llmtech.api.openapi.model.ApiResponseUsuarioRegiaoListDTO;
import br.com.llmtech.api.service.UsuarioRegiaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario-regiao")
@Tag(name = "usuario-regiao", description = "CRUD de Usuário-Região")
public class UsuarioRegiaoController {

    private final UsuarioRegiaoService usuarioRegiaoService;

    public UsuarioRegiaoController(UsuarioRegiaoService usuarioRegiaoService) {
        this.usuarioRegiaoService = usuarioRegiaoService;
    }

    @Operation(summary = "Cria uma nova relação usuário-região")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Relação criada com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiResponseUsuarioRegiaoDTO.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class))),
            @ApiResponse(responseCode = "422", description = "Parâmetros informados não atendem aos requisitos esperados", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class)))
    })
    @PostMapping
    public ResponseEntity<UsuarioRegiaoResponseDTO> create(@RequestBody UsuarioRegiaoRequestDTO dto) {
        UsuarioRegiaoResponseDTO response = usuarioRegiaoService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(
            summary = "Lista todas as relações usuário-região",
            parameters = {
                    @Parameter(name = "page", description = "Número da página (0..N)", example = "0"),
                    @Parameter(name = "size", description = "Quantidade de elementos por página", example = "10"),
                    @Parameter(name = "sort", description = "Critério de ordenação no formato: propriedade[,asc|desc].")
            }
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listagem bem-sucedida", content = @Content(schema = @Schema(implementation = ApiResponseUsuarioRegiaoListDTO.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class)))
    })
    @GetMapping
    public ResponseEntity<ApiResponseDTO<List<UsuarioRegiaoResponseDTO>>> list(@PageableDefault Pageable pageable) {
        Page<UsuarioRegiaoResponseDTO> page = usuarioRegiaoService.findAll(pageable);
        ApiResponseDTO<List<UsuarioRegiaoResponseDTO>> response = new ApiResponseDTO<>(page.getContent());
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Busca relação usuário-região por IDs")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Relação encontrada", content = @Content(schema = @Schema(implementation = ApiResponseUsuarioRegiaoDTO.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class))),
            @ApiResponse(responseCode = "404", description = "Relação não encontrada para os IDs fornecidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class)))
    })
    @GetMapping("/{idUsuario}/{idRegiao}")
    public ResponseEntity<UsuarioRegiaoResponseDTO> get(@PathVariable Long idUsuario, @PathVariable Long idRegiao) {
        UsuarioRegiaoResponseDTO response = usuarioRegiaoService.findById(idUsuario, idRegiao);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Remove uma relação usuário-região")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Relação removida com sucesso"),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class))),
            @ApiResponse(responseCode = "404", description = "Relação não encontrada para os IDs fornecidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class)))
    })
    @DeleteMapping("/{idUsuario}/{idRegiao}")
    public ResponseEntity<Void> delete(@PathVariable Long idUsuario, @PathVariable Long idRegiao) {
        usuarioRegiaoService.delete(idUsuario, idRegiao);
        return ResponseEntity.noContent().build();
    }
}