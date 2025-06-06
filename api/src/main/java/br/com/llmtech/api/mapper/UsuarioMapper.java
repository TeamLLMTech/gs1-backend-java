package br.com.llmtech.api.mapper;

import br.com.llmtech.api.dto.UsuarioRequestDTO;
import br.com.llmtech.api.dto.UsuarioResponseDTO;
import br.com.llmtech.api.model.Usuario;

public class UsuarioMapper {
    public static UsuarioResponseDTO toDTO(Usuario usuario) {
        UsuarioResponseDTO dto = new UsuarioResponseDTO();
        dto.setIdUsuario(usuario.getIdUsuario());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        dto.setSenha(usuario.getSenha());
        dto.setPerfil(usuario.getPerfil());
        dto.setAtivo(usuario.getAtivo());
        dto.setDataCadastro(usuario.getDataCadastro());
        return dto;
    }

    public static Usuario fromDTO(UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        usuario.setPerfil(dto.getPerfil());
        usuario.setAtivo(dto.getAtivo());
        usuario.setDataCadastro(dto.getDataCadastro());
        return usuario;
    }

    public static void updateEntityUsingDTO(Usuario usuario, UsuarioRequestDTO dto) {
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        usuario.setPerfil(dto.getPerfil());
        usuario.setAtivo(dto.getAtivo());
        usuario.setDataCadastro(dto.getDataCadastro());
    }
}
