package br.com.llmtech.api.model;

import java.util.List;

import jakarta.persistence.*;

@Entity(name = "REGIOESMONITORADAS")
public class RegiaoMonitorada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegiao;

    @Column(nullable = false, length = 100)
    private String nomeRegiao;

    @Column(nullable = false, length = 20)
    private String tipoZona;

    @Column
    private Integer populacaoEstimada;

    @Column()
    private String descriacaoArea;

    @ManyToOne
    @JoinColumn(name = "id_municipio", nullable = false)
    private Municipio municipio;

    @OneToMany(mappedBy = "regiao")
    private List<Evento> eventos;

    public Long getIdRegiao() {
        return idRegiao;
    }

    public void setIdRegiao(Long idRegiao) {
        this.idRegiao = idRegiao;
    }

    public String getNomeRegiao() {
        return nomeRegiao;
    }

    public void setNomeRegiao(String nomeRegiao) {
        this.nomeRegiao = nomeRegiao;
    }

    public String getTipoZona() {
        return tipoZona;
    }

    public void setTipoZona(String tipoZona) {
        this.tipoZona = tipoZona;
    }

    public Integer getPopulacaoEstimada() {
        return populacaoEstimada;
    }

    public void setPopulacaoEstimada(Integer populacaoEstimada) {
        this.populacaoEstimada = populacaoEstimada;
    }

    public String getDescriacaoArea() {
        return descriacaoArea;
    }

    public void setDescriacaoArea(String descriacaoArea) {
        this.descriacaoArea = descriacaoArea;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
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
