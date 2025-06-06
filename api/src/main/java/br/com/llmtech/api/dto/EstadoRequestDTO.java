package br.com.llmtech.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;

public class EstadoRequestDTO {

    @NotBlank(message = "Campo \"nome\" é obrigatório")
    private String nome;

    @Size(min = 2, max = 2, message = "Sigla deve conter exatamente 2 caracteres")
    @NotBlank(message = "Campo \"sigla\" é obrigatório")
    private String sigla;

    @NotNull(message = "Campo \"idPais\" é obrigatório")
    private Long idPais;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }
}
