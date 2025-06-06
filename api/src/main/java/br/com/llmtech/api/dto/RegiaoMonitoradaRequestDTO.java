package br.com.llmtech.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RegiaoMonitoradaRequestDTO {
    @NotBlank(message = "Campo \"nomeRegiao\" é obrigatório")
    private String nomeRegiao;

    @NotBlank(message = "Campo \"tipoZona\" é obrigatório")
    private String tipoZona;

    private Integer populacaoEstimada;
    private String descriacaoArea;

    @NotNull(message = "Campo \"idMunicipio\" é obrigatório")
    private Long idMunicipio;

    public String getNomeRegiao() { return nomeRegiao; }
    public void setNomeRegiao(String nomeRegiao) { this.nomeRegiao = nomeRegiao; }
    public String getTipoZona() { return tipoZona; }
    public void setTipoZona(String tipoZona) { this.tipoZona = tipoZona; }
    public Integer getPopulacaoEstimada() { return populacaoEstimada; }
    public void setPopulacaoEstimada(Integer populacaoEstimada) { this.populacaoEstimada = populacaoEstimada; }
    public String getDescriacaoArea() { return descriacaoArea; }
    public void setDescriacaoArea(String descriacaoArea) { this.descriacaoArea = descriacaoArea; }
    public Long getIdMunicipio() { return idMunicipio; }
    public void setIdMunicipio(Long idMunicipio) { this.idMunicipio = idMunicipio; }
}
