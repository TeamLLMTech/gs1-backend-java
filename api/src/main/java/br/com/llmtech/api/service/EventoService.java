package br.com.llmtech.api.service;

import br.com.llmtech.api.dto.EventoRequestDTO;
import br.com.llmtech.api.dto.EventoResponseDTO;
import br.com.llmtech.api.exception.NotFoundException;
import br.com.llmtech.api.mapper.EventoMapper;
import br.com.llmtech.api.model.Evento;
import br.com.llmtech.api.model.ModeloIA;
import br.com.llmtech.api.model.TipoEventoNatural;
import br.com.llmtech.api.model.RegiaoMonitorada;
import br.com.llmtech.api.repository.EventoRepository;
import br.com.llmtech.api.repository.ModeloIARepository;
import br.com.llmtech.api.repository.TipoEventoNaturalRepository;
import br.com.llmtech.api.repository.RegiaoMonitoradaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventoService {
    private final EventoRepository eventoRepository;
    private final ModeloIARepository modeloIARepository;
    private final TipoEventoNaturalRepository tipoEventoNaturalRepository;
    private final RegiaoMonitoradaRepository regiaoMonitoradaRepository;

    public EventoService(EventoRepository eventoRepository, ModeloIARepository modeloIARepository,
                        TipoEventoNaturalRepository tipoEventoNaturalRepository, RegiaoMonitoradaRepository regiaoMonitoradaRepository) {
        this.eventoRepository = eventoRepository;
        this.modeloIARepository = modeloIARepository;
        this.tipoEventoNaturalRepository = tipoEventoNaturalRepository;
        this.regiaoMonitoradaRepository = regiaoMonitoradaRepository;
    }

    @Transactional
    public EventoResponseDTO save(EventoRequestDTO dto) {
        ModeloIA modelo = modeloIARepository.findById(dto.getIdModelo())
            .orElseThrow(() -> new NotFoundException("ModeloIA não encontrado com o ID: " + dto.getIdModelo()));
        TipoEventoNatural tipoEvento = tipoEventoNaturalRepository.findById(dto.getIdTipoEvento())
            .orElseThrow(() -> new NotFoundException("TipoEventoNatural não encontrado com o ID: " + dto.getIdTipoEvento()));
        RegiaoMonitorada regiao = regiaoMonitoradaRepository.findById(dto.getIdRegiao())
            .orElseThrow(() -> new NotFoundException("RegiaoMonitorada não encontrada com o ID: " + dto.getIdRegiao()));
        Evento saved = eventoRepository.save(EventoMapper.fromDTO(dto, modelo, tipoEvento, regiao));
        return EventoMapper.toDTO(saved);
    }

    public Page<EventoResponseDTO> findAll(Pageable pageable) {
        return eventoRepository.findAll(pageable).map(EventoMapper::toDTO);
    }

    public EventoResponseDTO findById(Long id) {
        return eventoRepository.findById(id)
            .map(EventoMapper::toDTO)
            .orElseThrow(() -> new NotFoundException("Evento não encontrado com o ID: " + id));
    }

    @Transactional
    public EventoResponseDTO update(Long id, EventoRequestDTO dto) {
        Evento evento = eventoRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Evento não encontrado com o ID: " + id));
        ModeloIA modelo = modeloIARepository.findById(dto.getIdModelo())
            .orElseThrow(() -> new NotFoundException("ModeloIA não encontrado com o ID: " + dto.getIdModelo()));
        TipoEventoNatural tipoEvento = tipoEventoNaturalRepository.findById(dto.getIdTipoEvento())
            .orElseThrow(() -> new NotFoundException("TipoEventoNatural não encontrado com o ID: " + dto.getIdTipoEvento()));
        RegiaoMonitorada regiao = regiaoMonitoradaRepository.findById(dto.getIdRegiao())
            .orElseThrow(() -> new NotFoundException("RegiaoMonitorada não encontrada com o ID: " + dto.getIdRegiao()));
        EventoMapper.updateEntityUsingDTO(evento, dto, modelo, tipoEvento, regiao);
        return EventoMapper.toDTO(eventoRepository.save(evento));
    }

    @Transactional
    public void delete(Long id) {
        if (!eventoRepository.existsById(id)) {
            throw new NotFoundException("Evento não encontrado com o ID: " + id);
        }
        eventoRepository.deleteById(id);
    }
}
