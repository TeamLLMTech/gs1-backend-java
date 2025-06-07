package br.com.llmtech.api.controller;

import br.com.llmtech.api.dto.EventoRequestDTO;
import br.com.llmtech.api.dto.EventoResponseDTO;
import br.com.llmtech.api.dto.common.ApiErrorDTO;
import br.com.llmtech.api.dto.common.ApiResponseDTO;
import br.com.llmtech.api.openapi.model.ApiResponseEventoDTO;
import br.com.llmtech.api.openapi.model.ApiResponseEventoListDTO;
import br.com.llmtech.api.service.EventoService;
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
@RequestMapping("/eventos")
@Tag(name = "eventos", description = "CRUD de Eventos")
@SecurityRequirement(name = "Bearer Authentication")
public class EventoController {

    private final EventoService eventoService;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @Operation(summary = "Cria um novo evento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Evento criado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiResponseEventoDTO.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class))),
            @ApiResponse(responseCode = "422", description = "Parâmetros informados não atendem aos requisitos esperados", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class)))
    })
    @PostMapping
    public ResponseEntity<EventoResponseDTO> create(@Valid @RequestBody EventoRequestDTO dto) {
        EventoResponseDTO response = eventoService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(
            summary = "Lista todos os eventos",
            parameters = {
                    @Parameter(name = "page", description = "Número da página (0..N)", example = "0"),
                    @Parameter(name = "size", description = "Quantidade de elementos por página", example = "10"),
                    @Parameter(name = "sort", description = "Critério de ordenação no formato: propriedade[,asc|desc].")
            }
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listagem de eventos bem-sucedida", content = @Content(schema = @Schema(implementation = ApiResponseEventoListDTO.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class)))
    })
    @GetMapping
    public ResponseEntity<ApiResponseDTO<List<EventoResponseDTO>>> findAll(@Parameter(hidden = true) @PageableDefault Pageable pageable) {
        Page<EventoResponseDTO> page = eventoService.findAll(pageable);
        ApiResponseDTO<List<EventoResponseDTO>> response = new ApiResponseDTO<>(page.getContent());
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Busca evento por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Evento encontrado", content = @Content(schema = @Schema(implementation = ApiResponseEventoDTO.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class))),
            @ApiResponse(responseCode = "404", description = "Evento não encontrado para o ID fornecido", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class)))
    })
    @GetMapping("/{id}")
    public ResponseEntity<EventoResponseDTO> findById(@PathVariable Long id) {
        EventoResponseDTO response = eventoService.findById(id);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Atualiza um evento existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Evento atualizado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiResponseEventoDTO.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class))),
            @ApiResponse(responseCode = "404", description = "Evento não encontrado para o ID fornecido", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class))),
            @ApiResponse(responseCode = "422", description = "Parâmetros informados não atendem aos requisitos esperados", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class)))
    })
    @PutMapping("/{id}")
    public ResponseEntity<EventoResponseDTO> update(@PathVariable Long id, @Valid @RequestBody EventoRequestDTO dto) {
        EventoResponseDTO response = eventoService.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Remove um evento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Evento removido com sucesso"),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class))),
            @ApiResponse(responseCode = "404", description = "Evento não encontrado para o ID fornecido", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        eventoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
