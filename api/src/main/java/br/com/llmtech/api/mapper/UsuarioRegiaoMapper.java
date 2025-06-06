package br.com.llmtech.api.mapper;

import br.com.llmtech.api.dto.UsuarioRegiaoRequestDTO;
import br.com.llmtech.api.dto.UsuarioRegiaoResponseDTO;
import br.com.llmtech.api.model.UsuarioRegiao;
import br.com.llmtech.api.model.Usuario;
import br.com.llmtech.api.model.RegiaoMonitorada;

public class UsuarioRegiaoMapper {
    public static UsuarioRegiaoResponseDTO toDTO(UsuarioRegiao usuarioRegiao) {
        UsuarioRegiaoResponseDTO dto = new UsuarioRegiaoResponseDTO();
        dto.setIdUsuario(usuarioRegiao.getIdUsuario());
        dto.setIdRegiao(usuarioRegiao.getIdRegiao());
        return dto;
    }

    public static UsuarioRegiao fromDTO(UsuarioRegiaoRequestDTO dto, Usuario usuario, RegiaoMonitorada regiao) {
        UsuarioRegiao usuarioRegiao = new UsuarioRegiao();
        usuarioRegiao.setIdUsuario(dto.getIdUsuario());
        usuarioRegiao.setIdRegiao(dto.getIdRegiao());
        usuarioRegiao.setUsuario(usuario);
        usuarioRegiao.setRegiao(regiao);
        return usuarioRegiao;
    }

    public static void updateEntityUsingDTO(UsuarioRegiao usuarioRegiao, UsuarioRegiaoRequestDTO dto, Usuario usuario, RegiaoMonitorada regiao) {
        usuarioRegiao.setIdUsuario(dto.getIdUsuario());
        usuarioRegiao.setIdRegiao(dto.getIdRegiao());
        usuarioRegiao.setUsuario(usuario);
        usuarioRegiao.setRegiao(regiao);
    }
}
