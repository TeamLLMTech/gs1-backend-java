package br.com.llmtech.api.controller;

import br.com.llmtech.api.dto.TipoEventoNaturalRequestDTO;
import br.com.llmtech.api.dto.TipoEventoNaturalResponseDTO;
import br.com.llmtech.api.dto.common.ApiErrorDTO;
import br.com.llmtech.api.dto.common.ApiResponseDTO;
import br.com.llmtech.api.openapi.model.ApiResponseTipoEventoNaturalDTO;
import br.com.llmtech.api.openapi.model.ApiResponseTipoEventoNaturalListDTO;
import br.com.llmtech.api.service.TipoEventoNaturalService;
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
@RequestMapping("/tipos-evento-natural")
@Tag(name = "tipos-evento-natural", description = "CRUD de Tipos de Evento Natural")
public class TipoEventoNaturalController {

    private final TipoEventoNaturalService tipoEventoNaturalService;

    public TipoEventoNaturalController(TipoEventoNaturalService tipoEventoNaturalService) {
        this.tipoEventoNaturalService = tipoEventoNaturalService;
    }

    @Operation(summary = "Cria um novo tipo de evento natural")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Tipo de evento natural criado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiResponseTipoEventoNaturalDTO.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class))),
            @ApiResponse(responseCode = "422", description = "Parâmetros informados não atendem aos requisitos esperados", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class)))
    })
    @PostMapping
    public ResponseEntity<TipoEventoNaturalResponseDTO> create(@Valid @RequestBody TipoEventoNaturalRequestDTO dto) {
        TipoEventoNaturalResponseDTO response = tipoEventoNaturalService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(
            summary = "Lista todos os tipos de evento natural",
            parameters = {
                    @Parameter(name = "page", description = "Número da página (0..N)", example = "0"),
                    @Parameter(name = "size", description = "Quantidade de elementos por página", example = "10"),
                    @Parameter(name = "sort", description = "Critério de ordenação no formato: propriedade[,asc|desc].")
            }
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listagem de tipos de evento natural bem-sucedida", content = @Content(schema = @Schema(implementation = ApiResponseTipoEventoNaturalListDTO.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class)))
    })
    @GetMapping
    public ResponseEntity<ApiResponseDTO<List<TipoEventoNaturalResponseDTO>>> findAll(@PageableDefault Pageable pageable) {
        Page<TipoEventoNaturalResponseDTO> page = tipoEventoNaturalService.findAll(pageable);
        ApiResponseDTO<List<TipoEventoNaturalResponseDTO>> response = new ApiResponseDTO<>(page.getContent());
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Busca tipo de evento natural por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tipo de evento natural encontrado", content = @Content(schema = @Schema(implementation = ApiResponseTipoEventoNaturalDTO.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class))),
            @ApiResponse(responseCode = "404", description = "Tipo de evento natural não encontrado para o ID fornecido", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class)))
    })
    @GetMapping("/{id}")
    public ResponseEntity<TipoEventoNaturalResponseDTO> findById(@PathVariable Long id) {
        TipoEventoNaturalResponseDTO response = tipoEventoNaturalService.findById(id);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Atualiza um tipo de evento natural existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tipo de evento natural atualizado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiResponseTipoEventoNaturalDTO.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class))),
            @ApiResponse(responseCode = "404", description = "Tipo de evento natural não encontrado para o ID fornecido", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class))),
            @ApiResponse(responseCode = "422", description = "Parâmetros informados não atendem aos requisitos esperados", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class)))
    })
    @PutMapping("/{id}")
    public ResponseEntity<TipoEventoNaturalResponseDTO> update(@PathVariable Long id, @Valid @RequestBody TipoEventoNaturalRequestDTO dto) {
        TipoEventoNaturalResponseDTO response = tipoEventoNaturalService.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Remove um tipo de evento natural")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Tipo de evento natural removido com sucesso"),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class))),
            @ApiResponse(responseCode = "404", description = "Tipo de evento natural não encontrado para o ID fornecido", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        tipoEventoNaturalService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
