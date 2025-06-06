package br.com.llmtech.api.dto;

import java.math.BigDecimal;
import java.util.Date;

public class ModeloIAResponseDTO {
    private Long idModelo;
    private String nomeModelo;
    private String tipoModelo;
    private String algoritmoBase;
    private Date dataTreinamento;
    private BigDecimal acuracia;
    private String descricaoModelo;

    public Long getIdModelo() { return idModelo; }
    public void setIdModelo(Long idModelo) { this.idModelo = idModelo; }

    public String getNomeModelo() { return nomeModelo; }
    public void setNomeModelo(String nomeModelo) { this.nomeModelo = nomeModelo; }

    public String getTipoModelo() { return tipoModelo; }
    public void setTipoModelo(String tipoModelo) { this.tipoModelo = tipoModelo; }

    public String getAlgoritmoBase() { return algoritmoBase; }
    public void setAlgoritmoBase(String algoritmoBase) { this.algoritmoBase = algoritmoBase; }

    public Date getDataTreinamento() { return dataTreinamento; }
    public void setDataTreinamento(Date dataTreinamento) { this.dataTreinamento = dataTreinamento; }

    public BigDecimal getAcuracia() { return acuracia; }
    public void setAcuracia(BigDecimal acuracia) { this.acuracia = acuracia; }

    public String getDescricaoModelo() { return descricaoModelo; }
    public void setDescricaoModelo(String descricaoModelo) { this.descricaoModelo = descricaoModelo; }
}
