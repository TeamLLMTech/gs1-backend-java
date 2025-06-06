package br.com.llmtech.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class MunicipioRequestDTO {

    @NotBlank(message = "Campo \"nome\" é obrigatório")
    private String nome;

    @NotNull(message = "Campo \"idEstado\" é obrigatório")
    private Long idEstado;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }
}
