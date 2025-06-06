package br.com.llmtech.api.service;

import br.com.llmtech.api.dto.AlertaRequestDTO;
import br.com.llmtech.api.dto.AlertaResponseDTO;
import br.com.llmtech.api.exception.NotFoundException;
import br.com.llmtech.api.mapper.AlertaMapper;
import br.com.llmtech.api.model.Alerta;
import br.com.llmtech.api.model.Evento;
import br.com.llmtech.api.repository.AlertaRepository;
import br.com.llmtech.api.repository.EventoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlertaService {
    private final AlertaRepository alertaRepository;
    private final EventoRepository eventoRepository;

    public AlertaService(AlertaRepository alertaRepository, EventoRepository eventoRepository) {
        this.alertaRepository = alertaRepository;
        this.eventoRepository = eventoRepository;
    }

    @Transactional
    public AlertaResponseDTO save(AlertaRequestDTO dto) {
        Evento evento = eventoRepository.findById(dto.getIdEvento())
            .orElseThrow(() -> new NotFoundException("Evento não encontrado com o ID: " + dto.getIdEvento()));
        Alerta saved = alertaRepository.save(AlertaMapper.fromDTO(dto, evento));
        return AlertaMapper.toDTO(saved);
    }

    public Page<AlertaResponseDTO> findAll(Pageable pageable) {
        return alertaRepository.findAll(pageable).map(AlertaMapper::toDTO);
    }

    public AlertaResponseDTO findById(Long id) {
        return alertaRepository.findById(id)
            .map(AlertaMapper::toDTO)
            .orElseThrow(() -> new NotFoundException("Alerta não encontrado com o ID: " + id));
    }

    @Transactional
    public AlertaResponseDTO update(Long id, AlertaRequestDTO dto) {
        Alerta alerta = alertaRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Alerta não encontrado com o ID: " + id));
        Evento evento = eventoRepository.findById(dto.getIdEvento())
            .orElseThrow(() -> new NotFoundException("Evento não encontrado com o ID: " + dto.getIdEvento()));
        AlertaMapper.updateEntityUsingDTO(alerta, dto, evento);
        return AlertaMapper.toDTO(alertaRepository.save(alerta));
    }

    @Transactional
    public void delete(Long id) {
        if (!alertaRepository.existsById(id)) {
            throw new NotFoundException("Alerta não encontrado com o ID: " + id);
        }
        alertaRepository.deleteById(id);
    }
}
