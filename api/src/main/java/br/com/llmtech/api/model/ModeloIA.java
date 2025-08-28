package br.com.llmtech.api.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity(name = "MODELOSIA")
public class ModeloIA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idModelo;

    @Column(nullable = false, length = 100)
    private String nomeModelo;

    @Column(nullable = false, length = 50)
    private String tipoModelo;

    @Column(length = 100)
    private String algoritmoBase;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataTreinamento;

    @Column(precision = 5, scale = 2)
    private BigDecimal acuracia;

    @Column()
    private String descricaoModelo;

    @OneToMany(mappedBy = "modelo")
    private List<Evento> eventos;

    public Long getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Long idModelo) {
        this.idModelo = idModelo;
    }

    public String getNomeModelo() {
        return nomeModelo;
    }

    public void setNomeModelo(String nomeModelo) {
        this.nomeModelo = nomeModelo;
    }

    public String getTipoModelo() {
        return tipoModelo;
    }

    public void setTipoModelo(String tipoModelo) {
        this.tipoModelo = tipoModelo;
    }

    public String getAlgoritmoBase() {
        return algoritmoBase;
    }

    public void setAlgoritmoBase(String algoritmoBase) {
        this.algoritmoBase = algoritmoBase;
    }

    public Date getDataTreinamento() {
        return dataTreinamento;
    }

    public void setDataTreinamento(Date dataTreinamento) {
        this.dataTreinamento = dataTreinamento;
    }

    public BigDecimal getAcuracia() {
        return acuracia;
    }

    public void setAcuracia(BigDecimal acuracia) {
        this.acuracia = acuracia;
    }

    public String getDescricaoModelo() {
        return descricaoModelo;
    }

    public void setDescricaoModelo(String descricaoModelo) {
        this.descricaoModelo = descricaoModelo;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    // Getters and setters
    // ...
}
