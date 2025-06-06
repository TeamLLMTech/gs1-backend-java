package br.com.llmtech.api.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity(name = "ALERTAS")
public class Alerta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlerta;

    @Column(nullable = false)
    private Short nivelAlerta;

    @Column(nullable = false, columnDefinition = "CLOB")
    private String mensagemAlerta;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataEmissao;

    @ManyToOne
    @JoinColumn(name = "id_evento", nullable = false)
    private Evento evento;

    public Long getIdAlerta() {
        return idAlerta;
    }

    public void setIdAlerta(Long idAlerta) {
        this.idAlerta = idAlerta;
    }

    public Short getNivelAlerta() {
        return nivelAlerta;
    }

    public void setNivelAlerta(Short nivelAlerta) {
        this.nivelAlerta = nivelAlerta;
    }

    public String getMensagemAlerta() {
        return mensagemAlerta;
    }

    public void setMensagemAlerta(String mensagemAlerta) {
        this.mensagemAlerta = mensagemAlerta;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
