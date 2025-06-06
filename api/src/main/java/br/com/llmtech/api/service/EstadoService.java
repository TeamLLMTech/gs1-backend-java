package br.com.llmtech.api.service;

import br.com.llmtech.api.dto.EstadoRequestDTO;
import br.com.llmtech.api.dto.EstadoResponseDTO;
import br.com.llmtech.api.exception.NotFoundException;
import br.com.llmtech.api.mapper.EstadoMapper;
import br.com.llmtech.api.model.Estado;
import br.com.llmtech.api.model.Pais;
import br.com.llmtech.api.repository.EstadoRepository;
import br.com.llmtech.api.repository.PaisRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstadoService {

    private final EstadoRepository estadoRepository;
    private final PaisRepository paisRepository;

    public EstadoService(EstadoRepository estadoRepository, PaisRepository paisRepository) {
        this.estadoRepository = estadoRepository;
        this.paisRepository = paisRepository;
    }

    @Transactional
    public EstadoResponseDTO save(EstadoRequestDTO dto) {
        Pais pais = paisRepository.findById(dto.getIdPais())
                .orElseThrow(() -> new NotFoundException("País não encontrado com o ID: " + dto.getIdPais()));
        Estado saved = estadoRepository.save(EstadoMapper.fromDTO(dto, pais));
        return EstadoMapper.toDTO(saved);
    }

    public Page<EstadoResponseDTO> findAll(Pageable pageable) {
        return estadoRepository.findAll(pageable).map(EstadoMapper::toDTO);
    }

    public EstadoResponseDTO findById(Long id) {
        return estadoRepository.findById(id)
                .map(EstadoMapper::toDTO)
                .orElseThrow(() -> new NotFoundException("Estado não encontrado com o ID: " + id));
    }

    @Transactional
    public EstadoResponseDTO update(Long id, EstadoRequestDTO dto) {
        Estado estado = estadoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Estado não encontrado com o ID: " + id));
        Pais pais = paisRepository.findById(dto.getIdPais())
                .orElseThrow(() -> new NotFoundException("País não encontrado com o ID: " + dto.getIdPais()));
        EstadoMapper.updateEntityUsingDTO(estado, dto, pais);
        return EstadoMapper.toDTO(estadoRepository.save(estado));
    }

    @Transactional
    public void delete(Long id) {
        if (!estadoRepository.existsById(id)) {
            throw new NotFoundException("Estado não encontrado com o ID: " + id);
        }
        estadoRepository.deleteById(id);
    }
}
