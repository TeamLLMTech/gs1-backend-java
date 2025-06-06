package br.com.llmtech.api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import java.util.Date;

public class AlertaRequestDTO {
    @NotNull(message = "Campo \"nivelAlerta\" é obrigatório")
    private Short nivelAlerta;

    @NotBlank(message = "Campo \"mensagemAlerta\" é obrigatório")
    private String mensagemAlerta;

    @NotNull(message = "Campo \"dataEmissao\" é obrigatório")
    private Date dataEmissao;

    @NotNull(message = "Campo \"idEvento\" é obrigatório")
    private Long idEvento;

    public Short getNivelAlerta() { return nivelAlerta; }
    public void setNivelAlerta(Short nivelAlerta) { this.nivelAlerta = nivelAlerta; }

    public String getMensagemAlerta() { return mensagemAlerta; }
    public void setMensagemAlerta(String mensagemAlerta) { this.mensagemAlerta = mensagemAlerta; }

    public Date getDataEmissao() { return dataEmissao; }
    public void setDataEmissao(Date dataEmissao) { this.dataEmissao = dataEmissao; }

    public Long getIdEvento() { return idEvento; }
    public void setIdEvento(Long idEvento) { this.idEvento = idEvento; }
}
