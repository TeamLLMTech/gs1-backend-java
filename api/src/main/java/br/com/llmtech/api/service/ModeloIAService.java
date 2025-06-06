package br.com.llmtech.api.service;

import br.com.llmtech.api.dto.ModeloIARequestDTO;
import br.com.llmtech.api.dto.ModeloIAResponseDTO;
import br.com.llmtech.api.exception.NotFoundException;
import br.com.llmtech.api.mapper.ModeloIAMapper;
import br.com.llmtech.api.model.ModeloIA;
import br.com.llmtech.api.repository.ModeloIARepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ModeloIAService {
    private final ModeloIARepository modeloIARepository;

    public ModeloIAService(ModeloIARepository modeloIARepository) {
        this.modeloIARepository = modeloIARepository;
    }

    @Transactional
    public ModeloIAResponseDTO save(ModeloIARequestDTO dto) {
        ModeloIA saved = modeloIARepository.save(ModeloIAMapper.fromDTO(dto));
        return ModeloIAMapper.toDTO(saved);
    }

    public Page<ModeloIAResponseDTO> findAll(Pageable pageable) {
        return modeloIARepository.findAll(pageable).map(ModeloIAMapper::toDTO);
    }

    public ModeloIAResponseDTO findById(Long id) {
        return modeloIARepository.findById(id)
            .map(ModeloIAMapper::toDTO)
            .orElseThrow(() -> new NotFoundException("ModeloIA não encontrado com o ID: " + id));
    }

    @Transactional
    public ModeloIAResponseDTO update(Long id, ModeloIARequestDTO dto) {
        ModeloIA modelo = modeloIARepository.findById(id)
            .orElseThrow(() -> new NotFoundException("ModeloIA não encontrado com o ID: " + id));
        ModeloIAMapper.updateEntityUsingDTO(modelo, dto);
        return ModeloIAMapper.toDTO(modeloIARepository.save(modelo));
    }

    @Transactional
    public void delete(Long id) {
        if (!modeloIARepository.existsById(id)) {
            throw new NotFoundException("ModeloIA não encontrado com o ID: " + id);
        }
        modeloIARepository.deleteById(id);
    }
}
