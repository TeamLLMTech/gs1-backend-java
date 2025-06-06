package br.com.llmtech.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

public class UsuarioRequestDTO {
    @NotBlank(message = "Campo \"nome\" é obrigatório")
    private String nome;

    @NotBlank(message = "Campo \"email\" é obrigatório")
    private String email;

    @NotBlank(message = "Campo \"senha\" é obrigatório")
    private String senha;

    @NotBlank(message = "Campo \"perfil\" é obrigatório")
    private String perfil;

    @NotNull(message = "Campo \"ativo\" é obrigatório")
    private Integer ativo;

    @NotNull(message = "Campo \"dataCadastro\" é obrigatório")
    private Date dataCadastro;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    public String getPerfil() { return perfil; }
    public void setPerfil(String perfil) { this.perfil = perfil; }
    public Integer getAtivo() { return ativo; }
    public void setAtivo(Integer ativo) { this.ativo = ativo; }
    public Date getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(Date dataCadastro) { this.dataCadastro = dataCadastro; }
}
