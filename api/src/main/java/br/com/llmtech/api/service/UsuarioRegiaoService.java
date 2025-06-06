package br.com.llmtech.api.service;

import br.com.llmtech.api.dto.UsuarioRegiaoRequestDTO;
import br.com.llmtech.api.dto.UsuarioRegiaoResponseDTO;
import br.com.llmtech.api.exception.NotFoundException;
import br.com.llmtech.api.mapper.UsuarioRegiaoMapper;
import br.com.llmtech.api.model.UsuarioRegiao;
import br.com.llmtech.api.model.Usuario;
import br.com.llmtech.api.model.RegiaoMonitorada;
import br.com.llmtech.api.repository.UsuarioRegiaoRepository;
import br.com.llmtech.api.repository.UsuarioRepository;
import br.com.llmtech.api.repository.RegiaoMonitoradaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioRegiaoService {
    private final UsuarioRegiaoRepository usuarioRegiaoRepository;
    private final UsuarioRepository usuarioRepository;
    private final RegiaoMonitoradaRepository regiaoMonitoradaRepository;

    public UsuarioRegiaoService(UsuarioRegiaoRepository usuarioRegiaoRepository, UsuarioRepository usuarioRepository, RegiaoMonitoradaRepository regiaoMonitoradaRepository) {
        this.usuarioRegiaoRepository = usuarioRegiaoRepository;
        this.usuarioRepository = usuarioRepository;
        this.regiaoMonitoradaRepository = regiaoMonitoradaRepository;
    }

    @Transactional
    public UsuarioRegiaoResponseDTO save(UsuarioRegiaoRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getIdUsuario())
            .orElseThrow(() -> new NotFoundException("Usuário não encontrado com o ID: " + dto.getIdUsuario()));
        RegiaoMonitorada regiao = regiaoMonitoradaRepository.findById(dto.getIdRegiao())
            .orElseThrow(() -> new NotFoundException("RegiãoMonitorada não encontrada com o ID: " + dto.getIdRegiao()));
        UsuarioRegiao saved = usuarioRegiaoRepository.save(UsuarioRegiaoMapper.fromDTO(dto, usuario, regiao));
        return UsuarioRegiaoMapper.toDTO(saved);
    }

    public Page<UsuarioRegiaoResponseDTO> findAll(Pageable pageable) {
        return usuarioRegiaoRepository.findAll(pageable).map(UsuarioRegiaoMapper::toDTO);
    }

    public UsuarioRegiaoResponseDTO findById(Long idUsuario, Long idRegiao) {
        return usuarioRegiaoRepository.findByIdUsuarioAndIdRegiao(idUsuario, idRegiao)
            .map(UsuarioRegiaoMapper::toDTO)
            .orElseThrow(() -> new NotFoundException("Associação UsuarioRegiao não encontrada para os IDs: " + idUsuario + ", " + idRegiao));
    }

    @Transactional
    public void delete(Long idUsuario, Long idRegiao) {
        UsuarioRegiao usuarioRegiao = usuarioRegiaoRepository.findByIdUsuarioAndIdRegiao(idUsuario, idRegiao)
            .orElseThrow(() -> new NotFoundException("Associação UsuarioRegiao não encontrada para os IDs: " + idUsuario + ", " + idRegiao));
        usuarioRegiaoRepository.delete(usuarioRegiao);
    }
}
