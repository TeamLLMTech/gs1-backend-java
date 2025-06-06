package br.com.llmtech.api.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class TipoEventoNaturalRequestDTO {
    @NotBlank(message = "Campo \"tipoEvento\" é obrigatório")
    private String tipoEvento;

    private String descricao;

    @Max(value = 5, message = "Campo \"intensidadeEvento\" deve ser um valor entre 1 e 5")
    @Min(value = 1, message = "Campo \"intensidadeEvento\" deve ser um valor entre 1 e 5")
    private Short intensidadeEvento;

    public String getTipoEvento() { return tipoEvento; }
    public void setTipoEvento(String tipoEvento) { this.tipoEvento = tipoEvento; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Short getIntensidadeEvento() { return intensidadeEvento; }
    public void setIntensidadeEvento(Short intensidadeEvento) { this.intensidadeEvento = intensidadeEvento; }
}
