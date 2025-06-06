package br.com.llmtech.api.controller;

import br.com.llmtech.api.dto.RegiaoMonitoradaRequestDTO;
import br.com.llmtech.api.dto.RegiaoMonitoradaResponseDTO;
import br.com.llmtech.api.dto.common.ApiErrorDTO;
import br.com.llmtech.api.dto.common.ApiResponseDTO;
import br.com.llmtech.api.openapi.model.ApiResponseRegiaoMonitoradaDTO;
import br.com.llmtech.api.openapi.model.ApiResponseRegiaoMonitoradaListDTO;
import br.com.llmtech.api.service.RegiaoMonitoradaService;
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
@RequestMapping("/regioes-monitoradas")
@Tag(name = "regioes-monitoradas", description = "CRUD de Regiões Monitoradas")
public class RegiaoMonitoradaController {

    private final RegiaoMonitoradaService regiaoMonitoradaService;

    public RegiaoMonitoradaController(RegiaoMonitoradaService regiaoMonitoradaService) {
        this.regiaoMonitoradaService = regiaoMonitoradaService;
    }

    @Operation(summary = "Cria uma nova região monitorada")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Região monitorada criada com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiResponseRegiaoMonitoradaDTO.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class))),
            @ApiResponse(responseCode = "422", description = "Parâmetros informados não atendem aos requisitos esperados", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class)))
    })
    @PostMapping
    public ResponseEntity<RegiaoMonitoradaResponseDTO> create(@Valid @RequestBody RegiaoMonitoradaRequestDTO dto) {
        RegiaoMonitoradaResponseDTO response = regiaoMonitoradaService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(
            summary = "Lista todas as regiões monitoradas",
            parameters = {
                    @Parameter(name = "page", description = "Número da página (0..N)", example = "0"),
                    @Parameter(name = "size", description = "Quantidade de elementos por página", example = "10"),
                    @Parameter(name = "sort", description = "Critério de ordenação no formato: propriedade[,asc|desc].")
            }
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listagem de regiões monitoradas bem-sucedida", content = @Content(schema = @Schema(implementation = ApiResponseRegiaoMonitoradaListDTO.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class)))
    })
    @GetMapping
    public ResponseEntity<ApiResponseDTO<List<RegiaoMonitoradaResponseDTO>>> findAll(@PageableDefault Pageable pageable) {
        Page<RegiaoMonitoradaResponseDTO> page = regiaoMonitoradaService.findAll(pageable);
        ApiResponseDTO<List<RegiaoMonitoradaResponseDTO>> response = new ApiResponseDTO<>(page.getContent());
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Busca região monitorada por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Região monitorada encontrada", content = @Content(schema = @Schema(implementation = ApiResponseRegiaoMonitoradaDTO.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class))),
            @ApiResponse(responseCode = "404", description = "Região monitorada não encontrada para o ID fornecido", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class)))
    })
    @GetMapping("/{id}")
    public ResponseEntity<RegiaoMonitoradaResponseDTO> findById(@PathVariable Long id) {
        RegiaoMonitoradaResponseDTO response = regiaoMonitoradaService.findById(id);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Atualiza uma região monitorada existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Região monitorada atualizada com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiResponseRegiaoMonitoradaDTO.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class))),
            @ApiResponse(responseCode = "404", description = "Região monitorada não encontrada para o ID fornecido", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class))),
            @ApiResponse(responseCode = "422", description = "Parâmetros informados não atendem aos requisitos esperados", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class)))
    })
    @PutMapping("/{id}")
    public ResponseEntity<RegiaoMonitoradaResponseDTO> update(@PathVariable Long id, @Valid @RequestBody RegiaoMonitoradaRequestDTO dto) {
        RegiaoMonitoradaResponseDTO response = regiaoMonitoradaService.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Remove uma região monitorada")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Região monitorada removida com sucesso"),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class))),
            @ApiResponse(responseCode = "404", description = "Região monitorada não encontrada para o ID fornecido", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        regiaoMonitoradaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
