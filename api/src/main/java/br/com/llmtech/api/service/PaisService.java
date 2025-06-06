package br.com.llmtech.api.service;

import br.com.llmtech.api.dto.PaisRequestDTO;
import br.com.llmtech.api.dto.PaisResponseDTO;
import br.com.llmtech.api.exception.NotFoundException;
import br.com.llmtech.api.mapper.PaisMapper;
import br.com.llmtech.api.model.Pais;
import br.com.llmtech.api.repository.PaisRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaisService {

    private final PaisRepository paisRepository;

    public PaisService(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @Transactional
    public PaisResponseDTO save(PaisRequestDTO dto) {
        Pais saved = paisRepository.save(PaisMapper.fromDTO(dto));
        return PaisMapper.toDTO(saved);
    }

    public Page<PaisResponseDTO> findAll(Pageable pageable) {
        return paisRepository.findAll(pageable).map(PaisMapper::toDTO);
    }

    public PaisResponseDTO findById(Long id) {
        return paisRepository.findById(id)
                .map(PaisMapper::toDTO)
                .orElseThrow(() -> new NotFoundException("País não encontrado com o ID: " + id));
    }

    @Transactional
    public PaisResponseDTO update(Long id, PaisRequestDTO dto) {
        Pais pais = paisRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("País não encontrado com o ID: " + id));
        PaisMapper.updateEntityUsingDTO(pais, dto);
        return PaisMapper.toDTO(paisRepository.save(pais));
    }

    @Transactional
    public void delete(Long id) {
        if (!paisRepository.existsById(id)) {
            throw new NotFoundException("País não encontrado com o ID: " + id);
        }
        paisRepository.deleteById(id);
    }
}
