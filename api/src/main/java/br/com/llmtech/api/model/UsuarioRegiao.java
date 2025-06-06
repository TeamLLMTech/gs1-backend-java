package br.com.llmtech.api.model;

import jakarta.persistence.*;

@Entity(name = "USUARIOSREGIOES")
@IdClass(UsuarioRegiaoId.class)
public class UsuarioRegiao {
    @Id
    private Long idUsuario;

    @Id
    private Long idRegiao;

    @ManyToOne
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idRegiao", referencedColumnName = "idRegiao", insertable = false, updatable = false)
    private RegiaoMonitorada regiao;

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdRegiao() {
        return idRegiao;
    }

    public void setIdRegiao(Long idRegiao) {
        this.idRegiao = idRegiao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public RegiaoMonitorada getRegiao() {
        return regiao;
    }

    public void setRegiao(RegiaoMonitorada regiao) {
        this.regiao = regiao;
    }

    // Getters and setters
    // ...
}
