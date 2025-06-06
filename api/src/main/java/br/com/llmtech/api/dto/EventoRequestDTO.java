package br.com.llmtech.api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

public class EventoRequestDTO {
    @NotNull(message = "Campo \"dataPrevista\" é obrigatório")
    private Date dataPrevista;

    @NotNull(message = "Campo \"probabilidade\" é obrigatório")
    private BigDecimal probabilidade;

    @NotNull(message = "Campo \"geradoEm\" é obrigatório")
    private Date geradoEm;

    private String descricao;

    @NotNull(message = "Campo \"idModelo\" é obrigatório")
    private Long idModelo;

    @NotNull(message = "Campo \"idTipoEvento\" é obrigatório")
    private Long idTipoEvento;

    @NotNull(message = "Campo \"idRegiao\" é obrigatório")
    private Long idRegiao;

    private Date dataOcorrencia;

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
