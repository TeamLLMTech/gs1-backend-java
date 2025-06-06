package br.com.llmtech.api.controller;

import br.com.llmtech.api.dto.ModeloIARequestDTO;
import br.com.llmtech.api.dto.ModeloIAResponseDTO;
import br.com.llmtech.api.dto.common.ApiErrorDTO;
import br.com.llmtech.api.dto.common.ApiResponseDTO;
import br.com.llmtech.api.openapi.model.ApiResponseModeloIADTO;
import br.com.llmtech.api.openapi.model.ApiResponseModeloIAListDTO;
import br.com.llmtech.api.service.ModeloIAService;
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
@RequestMapping("/modelos-ia")
@Tag(name = "modelos-ia", description = "CRUD de Modelos de IA")
public class ModeloIAController {

    private final ModeloIAService modeloIAService;

    public ModeloIAController(ModeloIAService modeloIAService) {
        this.modeloIAService = modeloIAService;
    }

    @Operation(summary = "Cria um novo modelo de IA")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Modelo de IA criado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiResponseModeloIADTO.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class))),
            @ApiResponse(responseCode = "422", description = "Parâmetros informados não atendem aos requisitos esperados", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class)))
    })
    @PostMapping
    public ResponseEntity<ModeloIAResponseDTO> create(@Valid @RequestBody ModeloIARequestDTO dto) {
        ModeloIAResponseDTO response = modeloIAService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(
            summary = "Lista todos os modelos de IA",
            parameters = {
                    @Parameter(name = "page", description = "Número da página (0..N)", example = "0"),
                    @Parameter(name = "size", description = "Quantidade de elementos por página", example = "10"),
                    @Parameter(name = "sort", description = "Critério de ordenação no formato: propriedade[,asc|desc].")
            }
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listagem de modelos de IA bem-sucedida", content = @Content(schema = @Schema(implementation = ApiResponseModeloIAListDTO.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class)))
    })
    @GetMapping
    public ResponseEntity<ApiResponseDTO<List<ModeloIAResponseDTO>>> findAll(@PageableDefault Pageable pageable) {
        Page<ModeloIAResponseDTO> page = modeloIAService.findAll(pageable);
        ApiResponseDTO<List<ModeloIAResponseDTO>> response = new ApiResponseDTO<>(page.getContent());
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Busca modelo de IA por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Modelo de IA encontrado", content = @Content(schema = @Schema(implementation = ApiResponseModeloIADTO.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class))),
            @ApiResponse(responseCode = "404", description = "Modelo de IA não encontrado para o ID fornecido", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class)))
    })
    @GetMapping("/{id}")
    public ResponseEntity<ModeloIAResponseDTO> findById(@PathVariable Long id) {
        ModeloIAResponseDTO response = modeloIAService.findById(id);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Atualiza um modelo de IA existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Modelo de IA atualizado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiResponseModeloIADTO.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class))),
            @ApiResponse(responseCode = "404", description = "Modelo de IA não encontrado para o ID fornecido", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class))),
            @ApiResponse(responseCode = "422", description = "Parâmetros informados não atendem aos requisitos esperados", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class)))
    })
    @PutMapping("/{id}")
    public ResponseEntity<ModeloIAResponseDTO> update(@PathVariable Long id, @Valid @RequestBody ModeloIARequestDTO dto) {
        ModeloIAResponseDTO response = modeloIAService.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Remove um modelo de IA")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Modelo de IA removido com sucesso"),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class))),
            @ApiResponse(responseCode = "404", description = "Modelo de IA não encontrado para o ID fornecido", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        modeloIAService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
