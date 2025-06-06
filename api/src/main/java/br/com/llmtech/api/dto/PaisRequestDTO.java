package br.com.llmtech.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PaisRequestDTO {

    @NotBlank(message = "Campo \"nome\" é obrigatório")
    private String nome;

    @Size(min = 3, max = 3, message = "Sigla deve conter exatamente 3 caracteres")
    @NotBlank(message = "Campo \"sigla\" é obrigatório")
    private String sigla;

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
}
