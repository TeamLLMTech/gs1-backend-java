package br.com.llmtech.api.dto;

import jakarta.validation.constraints.NotNull;

public class UsuarioRegiaoRequestDTO {
    @NotNull(message = "Campo \"idUsuario\" é obrigatório")
    private Long idUsuario;

    @NotNull(message = "Campo \"idRegiao\" é obrigatório")
    private Long idRegiao;

    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }
    public Long getIdRegiao() { return idRegiao; }
    public void setIdRegiao(Long idRegiao) { this.idRegiao = idRegiao; }
}
