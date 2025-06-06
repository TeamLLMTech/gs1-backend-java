package br.com.llmtech.api.controller;

import br.com.llmtech.api.dto.PaisRequestDTO;
import br.com.llmtech.api.dto.PaisResponseDTO;
import br.com.llmtech.api.dto.common.ApiErrorDTO;
import br.com.llmtech.api.dto.common.ApiResponseDTO;
import br.com.llmtech.api.dto.common.ApiResponseWithPaginationDTO;
import br.com.llmtech.api.dto.common.PaginationDTO;
import br.com.llmtech.api.openapi.model.ApiResponsePaisDTO;
import br.com.llmtech.api.openapi.model.ApiResponsePaisListDTO;
import br.com.llmtech.api.service.PaisService;
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
@RequestMapping("/paises")
@Tag(name = "paises", description = "CRUD de Países")
public class PaisController {

    private final PaisService paisService;

    public PaisController(PaisService paisService) {
        this.paisService = paisService;
    }

    @Operation(summary = "Cria um novo país")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Criado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiResponsePaisDTO.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class))),
            @ApiResponse(responseCode = "422", description = "Parâmetros informados não atendem aos requisitos esperados", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class)))
    })
    @PostMapping
    public ResponseEntity<PaisResponseDTO> create(@Valid @RequestBody PaisRequestDTO dto) {
        return new ResponseEntity<>(paisService.save(dto), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Lista todos os países",
            parameters = {
                    @Parameter(name = "page", description = "Número da página (0..N)", example = "0"),
                    @Parameter(name = "size", description = "Quantidade de elementos por página", example = "10"),
                    @Parameter(name = "sort", description = "Critério de ordenação no formato: propriedade[,asc|desc].")
            }
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listagem bem-sucedida", content = @Content(schema = @Schema(implementation = ApiResponsePaisListDTO.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class)))
    })
    @GetMapping
    public ResponseEntity<ApiResponseDTO<List<PaisResponseDTO>>> findAll(@PageableDefault Pageable pageable) {
        Page<PaisResponseDTO> page = paisService.findAll(pageable);
        PaginationDTO pagination = PaginationDTO.fromPage(page);
        return ResponseEntity.ok(new ApiResponseWithPaginationDTO<>(page.getContent(), pagination));
    }

    @Operation(summary = "Busca país por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Encontrado", content = @Content(schema = @Schema(implementation = ApiResponsePaisDTO.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content( mediaType = "application/json", schema = @Schema( implementation = ApiErrorDTO.class ) ) ),
            @ApiResponse(responseCode = "404", description = "País não encontrado para o ID fornecido", content = @Content( mediaType = "application/json", schema = @Schema( implementation = ApiErrorDTO.class ) ) )
    })
    @GetMapping("/{id}")
    public ResponseEntity<PaisResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(paisService.findById(id));
    }

    @Operation(summary = "Atualiza um país")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atualizado com sucesso", content = @Content(schema = @Schema(implementation = ApiResponsePaisDTO.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class))),
            @ApiResponse(responseCode = "404", description = "País não encontrado para o ID fornecido", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class))),
            @ApiResponse(responseCode = "422", description = "Parâmetros informados não atendem aos requisitos esperados", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class)))
    })
    @PutMapping("/{id}")
    public ResponseEntity<PaisResponseDTO> update(@PathVariable Long id, @Valid @RequestBody PaisRequestDTO dto) {
        return ResponseEntity.ok(paisService.update(id, dto));
    }


    @Operation(summary = "Deleta um país")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Deletado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class))),
            @ApiResponse(responseCode = "404", description = "País não encontrado para o ID fornecido", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorDTO.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        paisService.delete(id);
        return ResponseEntity.noContent().build();
    }
}