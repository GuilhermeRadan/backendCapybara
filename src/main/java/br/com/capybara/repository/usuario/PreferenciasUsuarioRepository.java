package br.com.capybara.repository.usuario;

import br.com.capybara.models.usuario.PreferenciasUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreferenciasUsuarioRepository extends JpaRepository<PreferenciasUsuario, Long> {
}
