package br.com.llmtech.api.dto;

import java.util.Date;

public class AlertaResponseDTO {
    private Long idAlerta;
    private Short nivelAlerta;
    private String mensagemAlerta;
    private Date dataEmissao;
    private Long idEvento;

    public Long getIdAlerta() { return idAlerta; }
    public void setIdAlerta(Long idAlerta) { this.idAlerta = idAlerta; }

    public Short getNivelAlerta() { return nivelAlerta; }
    public void setNivelAlerta(Short nivelAlerta) { this.nivelAlerta = nivelAlerta; }

    public String getMensagemAlerta() { return mensagemAlerta; }
    public void setMensagemAlerta(String mensagemAlerta) { this.mensagemAlerta = mensagemAlerta; }

    public Date getDataEmissao() { return dataEmissao; }
    public void setDataEmissao(Date dataEmissao) { this.dataEmissao = dataEmissao; }

    public Long getIdEvento() { return idEvento; }
    public void setIdEvento(Long idEvento) { this.idEvento = idEvento; }
}
