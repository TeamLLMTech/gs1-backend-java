package br.com.llmtech.api.service;

import br.com.llmtech.api.dto.RegiaoMonitoradaRequestDTO;
import br.com.llmtech.api.dto.RegiaoMonitoradaResponseDTO;
import br.com.llmtech.api.exception.NotFoundException;
import br.com.llmtech.api.mapper.RegiaoMonitoradaMapper;
import br.com.llmtech.api.model.RegiaoMonitorada;
import br.com.llmtech.api.model.Municipio;
import br.com.llmtech.api.repository.RegiaoMonitoradaRepository;
import br.com.llmtech.api.repository.MunicipioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegiaoMonitoradaService {
    private final RegiaoMonitoradaRepository regiaoMonitoradaRepository;
    private final MunicipioRepository municipioRepository;

    public RegiaoMonitoradaService(RegiaoMonitoradaRepository regiaoMonitoradaRepository, MunicipioRepository municipioRepository) {
        this.regiaoMonitoradaRepository = regiaoMonitoradaRepository;
        this.municipioRepository = municipioRepository;
    }

    @Transactional
    public RegiaoMonitoradaResponseDTO save(RegiaoMonitoradaRequestDTO dto) {
        Municipio municipio = municipioRepository.findById(dto.getIdMunicipio())
            .orElseThrow(() -> new NotFoundException("Município não encontrado com o ID: " + dto.getIdMunicipio()));
        RegiaoMonitorada saved = regiaoMonitoradaRepository.save(RegiaoMonitoradaMapper.fromDTO(dto, municipio));
        return RegiaoMonitoradaMapper.toDTO(saved);
    }

    public Page<RegiaoMonitoradaResponseDTO> findAll(Pageable pageable) {
        return regiaoMonitoradaRepository.findAll(pageable).map(RegiaoMonitoradaMapper::toDTO);
    }

    public RegiaoMonitoradaResponseDTO findById(Long id) {
        return regiaoMonitoradaRepository.findById(id)
            .map(RegiaoMonitoradaMapper::toDTO)
            .orElseThrow(() -> new NotFoundException("RegiãoMonitorada não encontrada com o ID: " + id));
    }

    @Transactional
    public RegiaoMonitoradaResponseDTO update(Long id, RegiaoMonitoradaRequestDTO dto) {
        RegiaoMonitorada regiao = regiaoMonitoradaRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("RegiãoMonitorada não encontrada com o ID: " + id));
        Municipio municipio = municipioRepository.findById(dto.getIdMunicipio())
            .orElseThrow(() -> new NotFoundException("Município não encontrado com o ID: " + dto.getIdMunicipio()));
        RegiaoMonitoradaMapper.updateEntityUsingDTO(regiao, dto, municipio);
        return RegiaoMonitoradaMapper.toDTO(regiaoMonitoradaRepository.save(regiao));
    }

    @Transactional
    public void delete(Long id) {
        if (!regiaoMonitoradaRepository.existsById(id)) {
            throw new NotFoundException("RegiãoMonitorada não encontrada com o ID: " + id);
        }
        regiaoMonitoradaRepository.deleteById(id);
    }
}
