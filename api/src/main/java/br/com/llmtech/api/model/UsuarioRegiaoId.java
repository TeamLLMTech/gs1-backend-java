package br.com.llmtech.api.model;

import java.io.Serializable;
import java.util.Objects;

public class UsuarioRegiaoId implements Serializable {
    private Long idUsuario;
    private Long idRegiao;

    public UsuarioRegiaoId() {}
    public UsuarioRegiaoId(Long idUsuario, Long idRegiao) {
        this.idUsuario = idUsuario;
        this.idRegiao = idRegiao;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioRegiaoId that = (UsuarioRegiaoId) o;
        return Objects.equals(idUsuario, that.idUsuario) && Objects.equals(idRegiao, that.idRegiao);
    }
    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, idRegiao);
    }
}
