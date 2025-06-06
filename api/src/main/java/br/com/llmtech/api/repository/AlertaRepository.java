package br.com.llmtech.api.repository;

import br.com.llmtech.api.model.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertaRepository extends JpaRepository<Alerta, Long> {
}
