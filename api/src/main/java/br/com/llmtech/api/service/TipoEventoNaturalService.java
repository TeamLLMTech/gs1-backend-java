package br.com.llmtech.api.service;

import br.com.llmtech.api.dto.TipoEventoNaturalRequestDTO;
import br.com.llmtech.api.dto.TipoEventoNaturalResponseDTO;
import br.com.llmtech.api.exception.NotFoundException;
import br.com.llmtech.api.mapper.TipoEventoNaturalMapper;
import br.com.llmtech.api.model.TipoEventoNatural;
import br.com.llmtech.api.repository.TipoEventoNaturalRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TipoEventoNaturalService {
    private final TipoEventoNaturalRepository tipoEventoNaturalRepository;

    public TipoEventoNaturalService(TipoEventoNaturalRepository tipoEventoNaturalRepository) {
        this.tipoEventoNaturalRepository = tipoEventoNaturalRepository;
    }

    @Transactional
    public TipoEventoNaturalResponseDTO save(TipoEventoNaturalRequestDTO dto) {
        TipoEventoNatural saved = tipoEventoNaturalRepository.save(TipoEventoNaturalMapper.fromDTO(dto));
        return TipoEventoNaturalMapper.toDTO(saved);
    }

    public Page<TipoEventoNaturalResponseDTO> findAll(Pageable pageable) {
        return tipoEventoNaturalRepository.findAll(pageable).map(TipoEventoNaturalMapper::toDTO);
    }

    public TipoEventoNaturalResponseDTO findById(Long id) {
        return tipoEventoNaturalRepository.findById(id)
            .map(TipoEventoNaturalMapper::toDTO)
            .orElseThrow(() -> new NotFoundException("TipoEventoNatural não encontrado com o ID: " + id));
    }

    @Transactional
    public TipoEventoNaturalResponseDTO update(Long id, TipoEventoNaturalRequestDTO dto) {
        TipoEventoNatural tipo = tipoEventoNaturalRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("TipoEventoNatural não encontrado com o ID: " + id));
        TipoEventoNaturalMapper.updateEntityUsingDTO(tipo, dto);
        return TipoEventoNaturalMapper.toDTO(tipoEventoNaturalRepository.save(tipo));
    }

    @Transactional
    public void delete(Long id) {
        if (!tipoEventoNaturalRepository.existsById(id)) {
            throw new NotFoundException("TipoEventoNatural não encontrado com o ID: " + id);
        }
        tipoEventoNaturalRepository.deleteById(id);
    }
}
