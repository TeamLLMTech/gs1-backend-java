package br.com.llmtech.api.dto;

public class UsuarioLoginResponseDTO {

  private String token;

  public UsuarioLoginResponseDTO() {
  }

  public UsuarioLoginResponseDTO(String token) {
    this.token = token;
  }

  public String getToken() {
    return token;
  }
  public void setToken(String token) {
    this.token = token;
  }

}
