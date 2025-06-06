package br.com.llmtech.api.controller;

import br.com.llmtech.api.dto.EstadoRequestDTO;
import br.com.llmtech.api.dto.EstadoResponseDTO;
import br.com.llmtech.api.dto.common.ApiErrorDTO;
import br.com.llmtech.api.dto.common.ApiResponseDTO;
import br.com.llmtech.api.dto.common.ApiResponseWithPaginationDTO;
import br.com.llmtech.api.dto.common.PaginationDTO;
import br.com.llmtech.api.openapi.model.ApiResponseEstadoDTO;
import br.com.llmtech.api.openapi.model.ApiResponseEstadoListDTO;
import br.com.llmtech.api.service.EstadoService;
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
@RequestMapping("/estados")
@Tag(name = "estados", description = "CRUD de Estados")
public class EstadoController {

    private final EstadoService estadoService;

    public EstadoController(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    @Operation(summary = "Cria um novo estado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Criado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiResponseEstadoDTO.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class))),
            @ApiResponse(responseCode = "422", description = "Parâmetros informados não atendem aos requisitos esperados", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class)))
    })
    @PostMapping
    public ResponseEntity<EstadoResponseDTO> create(@Valid @RequestBody EstadoRequestDTO dto) {
        EstadoResponseDTO response = estadoService.save(dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Lista todos os estados",
            parameters = {
                    @Parameter(name = "page", description = "Número da página (0..N)", example = "0"),
                    @Parameter(name = "size", description = "Quantidade de elementos por página", example = "10"),
                    @Parameter(name = "sort", description = "Critério de ordenação no formato: propriedade[,asc|desc].")
            }
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listagem bem-sucedida", content = @Content(schema = @Schema(implementation = ApiResponseEstadoListDTO.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class)))
    })
    @GetMapping
    public ResponseEntity<ApiResponseDTO<List<EstadoResponseDTO>>> findAll(@PageableDefault Pageable pageable) {
        Page<EstadoResponseDTO> page = estadoService.findAll(pageable);
        PaginationDTO pagination = PaginationDTO.fromPage(page);
        return ResponseEntity.ok(new ApiResponseWithPaginationDTO<>(page.getContent(), pagination));
    }

    @Operation(summary = "Busca estado por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Encontrado", content = @Content(schema = @Schema(implementation = ApiResponseEstadoDTO.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content( mediaType = "application/json", schema = @Schema( implementation = ApiErrorDTO.class ) ) ),
            @ApiResponse(responseCode = "404", description = "Estado não encontrado para o ID fornecido", content = @Content( mediaType = "application/json", schema = @Schema( implementation = ApiErrorDTO.class ) ) )
    })
    @GetMapping("/{id}")
    public ResponseEntity<EstadoResponseDTO> findById(@PathVariable Long id) {
        EstadoResponseDTO response = estadoService.findById(id);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Atualiza um estado existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atualizado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiResponseEstadoDTO.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class))),
            @ApiResponse(responseCode = "404", description = "Estado não encontrado para o ID fornecido", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class))),
            @ApiResponse(responseCode = "422", description = "Parâmetros informados não atendem aos requisitos esperados", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class)))
    })
    @PutMapping("/{id}")
    public ResponseEntity<EstadoResponseDTO> update(@PathVariable Long id, @Valid @RequestBody EstadoRequestDTO dto) {
        EstadoResponseDTO response = estadoService.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Exclui um estado existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Excluído com sucesso"),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class))),
            @ApiResponse(responseCode = "404", description = "Estado não encontrado para o ID fornecido", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        estadoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
