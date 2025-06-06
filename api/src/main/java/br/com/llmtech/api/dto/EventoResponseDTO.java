package br.com.llmtech.api.dto;

import java.math.BigDecimal;
import java.util.Date;

public class EventoResponseDTO {
    private Long idEvento;
    private Date dataPrevista;
    private BigDecimal probabilidade;
    private Date geradoEm;
    private String descricao;
    private Long idModelo;
    private Long idTipoEvento;
    private Long idRegiao;
    private Date dataOcorrencia;

    public Long getIdEvento() { return idEvento; }
    public void setIdEvento(Long idEvento) { this.idEvento = idEvento; }

    public Date getDataPrevista() { return dataPrevista; }
    public void setDataPrevista(Date dataPrevista) { this.dataPrevista = dataPrevista; }

    public BigDecimal getProbabilidade() { return probabilidade; }
    public void setProbabilidade(BigDecimal probabilidade) { this.probabilidade = probabilidade; }

    public Date getGeradoEm() { return geradoEm; }
    public void setGeradoEm(Date geradoEm) { this.geradoEm = geradoEm; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Long getIdModelo() { return idModelo; }
    public void setIdModelo(Long idModelo) { this.idModelo = idModelo; }

    public Long getIdTipoEvento() { return idTipoEvento; }
    public void setIdTipoEvento(Long idTipoEvento) { this.idTipoEvento = idTipoEvento; }

    public Long getIdRegiao() { return idRegiao; }
    public void setIdRegiao(Long idRegiao) { this.idRegiao = idRegiao; }

    public Date getDataOcorrencia() { return dataOcorrencia; }
    public void setDataOcorrencia(Date dataOcorrencia) { this.dataOcorrencia = dataOcorrencia; }
}
