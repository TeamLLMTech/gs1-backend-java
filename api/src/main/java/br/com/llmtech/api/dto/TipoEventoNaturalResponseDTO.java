package br.com.llmtech.api.dto;

public class TipoEventoNaturalResponseDTO {
    private Long idTipoEvento;
    private String tipoEvento;
    private String descricao;
    private Short intensidadeEvento;

    public Long getIdTipoEvento() { return idTipoEvento; }
    public void setIdTipoEvento(Long idTipoEvento) { this.idTipoEvento = idTipoEvento; }
    public String getTipoEvento() { return tipoEvento; }
    public void setTipoEvento(String tipoEvento) { this.tipoEvento = tipoEvento; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Short getIntensidadeEvento() { return intensidadeEvento; }
    public void setIntensidadeEvento(Short intensidadeEvento) { this.intensidadeEvento = intensidadeEvento; }
}
