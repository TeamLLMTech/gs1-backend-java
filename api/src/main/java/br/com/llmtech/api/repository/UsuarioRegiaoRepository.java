package br.com.llmtech.api.repository;

import br.com.llmtech.api.model.UsuarioRegiao;
import br.com.llmtech.api.model.UsuarioRegiaoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRegiaoRepository extends JpaRepository<UsuarioRegiao, UsuarioRegiaoId> {
}
