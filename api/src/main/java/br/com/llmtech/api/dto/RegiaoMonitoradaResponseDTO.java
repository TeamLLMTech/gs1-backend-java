package br.com.llmtech.api.dto;

public class RegiaoMonitoradaResponseDTO {
    private Long idRegiao;
    private String nomeRegiao;
    private String tipoZona;
    private Integer populacaoEstimada;
    private String descriacaoArea;
    private Long idMunicipio;

    public Long getIdRegiao() { return idRegiao; }
    public void setIdRegiao(Long idRegiao) { this.idRegiao = idRegiao; }
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
