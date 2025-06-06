package br.com.llmtech.api.service;

import br.com.llmtech.api.dto.MunicipioRequestDTO;
import br.com.llmtech.api.dto.MunicipioResponseDTO;
import br.com.llmtech.api.exception.NotFoundException;
import br.com.llmtech.api.mapper.MunicipioMapper;
import br.com.llmtech.api.model.Estado;
import br.com.llmtech.api.model.Municipio;
import br.com.llmtech.api.repository.EstadoRepository;
import br.com.llmtech.api.repository.MunicipioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MunicipioService {

    private final MunicipioRepository municipioRepository;
    private final EstadoRepository estadoRepository;

    public MunicipioService(MunicipioRepository municipioRepository, EstadoRepository estadoRepository) {
        this.municipioRepository = municipioRepository;
        this.estadoRepository = estadoRepository;
    }

    @Transactional
    public MunicipioResponseDTO save(MunicipioRequestDTO dto) {
        Estado estado = estadoRepository.findById(dto.getIdEstado())
                .orElseThrow(() -> new NotFoundException("Estado não encontrado com o ID: " + dto.getIdEstado()));
        Municipio saved = municipioRepository.save(MunicipioMapper.fromDTO(dto, estado));
        return MunicipioMapper.toDTO(saved);
    }

    public Page<MunicipioResponseDTO> findAll(Pageable pageable) {
        return municipioRepository.findAll(pageable).map(MunicipioMapper::toDTO);
    }

    public MunicipioResponseDTO findById(Long id) {
        return municipioRepository.findById(id)
                .map(MunicipioMapper::toDTO)
                .orElseThrow(() -> new NotFoundException("Município não encontrado com o ID: " + id));
    }

    @Transactional
    public MunicipioResponseDTO update(Long id, MunicipioRequestDTO dto) {
        Municipio municipio = municipioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Município não encontrado com o ID: " + id));
        Estado estado = estadoRepository.findById(dto.getIdEstado())
                .orElseThrow(() -> new NotFoundException("Estado não encontrado com o ID: " + dto.getIdEstado()));
        MunicipioMapper.updateEntityUsingDTO(municipio, dto, estado);
        return MunicipioMapper.toDTO(municipioRepository.save(municipio));
    }

    @Transactional
    public void delete(Long id) {
        if (!municipioRepository.existsById(id)) {
            throw new NotFoundException("Município não encontrado com o ID: " + id);
        }
        municipioRepository.deleteById(id);
    }
}
