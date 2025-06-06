package br.com.llmtech.api.controller;

import br.com.llmtech.api.dto.UsuarioRegiaoRequestDTO;
import br.com.llmtech.api.dto.UsuarioRegiaoResponseDTO;
import br.com.llmtech.api.service.UsuarioRegiaoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario-regiao")
public class UsuarioRegiaoController {

    private final UsuarioRegiaoService usuarioRegiaoService;

    public UsuarioRegiaoController(UsuarioRegiaoService usuarioRegiaoService) {
        this.usuarioRegiaoService = usuarioRegiaoService;
    }

    @PostMapping
    public UsuarioRegiaoResponseDTO create(@RequestBody UsuarioRegiaoRequestDTO dto) {
        return usuarioRegiaoService.save(dto);
    }

    @GetMapping
    public Page<UsuarioRegiaoResponseDTO> list(Pageable pageable) {
        return usuarioRegiaoService.findAll(pageable);
    }

    @GetMapping("/{idUsuario}/{idRegiao}")
    public UsuarioRegiaoResponseDTO get(@PathVariable Long idUsuario, @PathVariable Long idRegiao) {
        return usuarioRegiaoService.findById(idUsuario, idRegiao);
    }

    @DeleteMapping("/{idUsuario}/{idRegiao}")
    public void delete(@PathVariable Long idUsuario, @PathVariable Long idRegiao) {
        usuarioRegiaoService.delete(idUsuario, idRegiao);
    }
}