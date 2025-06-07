package br.com.llmtech.api.controller;

import br.com.llmtech.api.dto.AlertaRequestDTO;
import br.com.llmtech.api.dto.AlertaResponseDTO;
import br.com.llmtech.api.dto.common.ApiErrorDTO;
import br.com.llmtech.api.dto.common.ApiResponseDTO;
import br.com.llmtech.api.openapi.model.ApiResponseAlertaDTO;
import br.com.llmtech.api.openapi.model.ApiResponseAlertaListDTO;
import br.com.llmtech.api.service.AlertaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
@RequestMapping("/alertas")
@Tag(name = "alertas", description = "CRUD de Alertas")
@SecurityRequirement(name = "Bearer Authentication")
public class AlertaController {

    private final AlertaService alertaService;

    public AlertaController(AlertaService alertaService) {
        this.alertaService = alertaService;
    }

    @Operation(summary = "Cria um novo alerta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Alerta criado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiResponseAlertaDTO.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class))),
            @ApiResponse(responseCode = "422", description = "Parâmetros informados não atendem aos requisitos esperados", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class)))
    })
    @PostMapping
    public ResponseEntity<AlertaResponseDTO> create(@Valid @RequestBody AlertaRequestDTO dto) {
        AlertaResponseDTO response = alertaService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(
            summary = "Lista todos os alertas",
            parameters = {
                    @Parameter(name = "page", description = "Número da página (0..N)", example = "0"),
                    @Parameter(name = "size", description = "Quantidade de elementos por página", example = "10"),
                    @Parameter(name = "sort", description = "Critério de ordenação no formato: propriedade[,asc|desc].")
            }
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listagem de alertas bem-sucedida", content = @Content(schema = @Schema(implementation = ApiResponseAlertaListDTO.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class)))
    })
    @GetMapping
    public ResponseEntity<ApiResponseDTO<List<AlertaResponseDTO>>> findAll(@Parameter(hidden = true) @PageableDefault Pageable pageable) {
        Page<AlertaResponseDTO> page = alertaService.findAll(pageable);
        ApiResponseDTO<List<AlertaResponseDTO>> response = new ApiResponseDTO<>(page.getContent());
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Busca alerta por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Alerta encontrado", content = @Content(schema = @Schema(implementation = ApiResponseAlertaDTO.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class))),
            @ApiResponse(responseCode = "404", description = "Alerta não encontrado para o ID fornecido", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class)))
    })
    @GetMapping("/{id}")
    public ResponseEntity<AlertaResponseDTO> findById(@PathVariable Long id) {
        AlertaResponseDTO response = alertaService.findById(id);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Atualiza um alerta existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Alerta atualizado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiResponseAlertaDTO.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class))),
            @ApiResponse(responseCode = "404", description = "Alerta não encontrado para o ID fornecido", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class))),
            @ApiResponse(responseCode = "422", description = "Parâmetros informados não atendem aos requisitos esperados", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class)))
    })
    @PutMapping("/{id}")
    public ResponseEntity<AlertaResponseDTO> update(@PathVariable Long id, @Valid @RequestBody AlertaRequestDTO dto) {
        AlertaResponseDTO response = alertaService.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Remove um alerta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Alerta removido com sucesso"),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class))),
            @ApiResponse(responseCode = "404", description = "Alerta não encontrado para o ID fornecido", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        alertaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
