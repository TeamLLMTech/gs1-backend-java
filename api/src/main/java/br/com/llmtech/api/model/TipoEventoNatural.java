package br.com.llmtech.api.model;

import java.util.List;

import jakarta.persistence.*;

@Entity(name = "TIPOSEVENTOSNATURAIS")
public class TipoEventoNatural {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoEvento;

    @Column(nullable = false, length = 50)
    private String tipoEvento;

    @Column()
    private String descricao;

    @Column
    private Short intensidadeEvento;

    @OneToMany(mappedBy = "tipoEvento")
    private List<Evento> eventos;

    public Long getIdTipoEvento() {
        return idTipoEvento;
    }

    public void setIdTipoEvento(Long idTipoEvento) {
        this.idTipoEvento = idTipoEvento;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Short getIntensidadeEvento() {
        return intensidadeEvento;
    }

    public void setIntensidadeEvento(Short intensidadeEvento) {
        this.intensidadeEvento = intensidadeEvento;
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
