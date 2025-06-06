package br.com.llmtech.api.service;

import br.com.llmtech.api.dto.UsuarioRequestDTO;
import br.com.llmtech.api.dto.UsuarioResponseDTO;
import br.com.llmtech.api.exception.NotFoundException;
import br.com.llmtech.api.mapper.UsuarioMapper;
import br.com.llmtech.api.model.Usuario;
import br.com.llmtech.api.repository.UsuarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public UsuarioResponseDTO save(UsuarioRequestDTO dto) {
        Usuario saved = usuarioRepository.save(UsuarioMapper.fromDTO(dto));
        return UsuarioMapper.toDTO(saved);
    }

    public Page<UsuarioResponseDTO> findAll(Pageable pageable) {
        return usuarioRepository.findAll(pageable).map(UsuarioMapper::toDTO);
    }

    public UsuarioResponseDTO findById(Long id) {
        return usuarioRepository.findById(id)
            .map(UsuarioMapper::toDTO)
            .orElseThrow(() -> new NotFoundException("Usuário não encontrado com o ID: " + id));
    }

    @Transactional
    public UsuarioResponseDTO update(Long id, UsuarioRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Usuário não encontrado com o ID: " + id));
        UsuarioMapper.updateEntityUsingDTO(usuario, dto);
        return UsuarioMapper.toDTO(usuarioRepository.save(usuario));
    }

    @Transactional
    public void delete(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new NotFoundException("Usuário não encontrado com o ID: " + id);
        }
        usuarioRepository.deleteById(id);
    }
}
