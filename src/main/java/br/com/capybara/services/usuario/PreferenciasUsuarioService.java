package br.com.capybara.services.usuario;

import br.com.capybara.dtos.usuario.PreferenciasUsuarioDTO;
import br.com.capybara.models.evento.CategoriaEvento;
import br.com.capybara.models.usuario.PreferenciasUsuario;
import br.com.capybara.models.usuario.Usuario;
import br.com.capybara.repository.evento.CategoriaEventoRepository;
import br.com.capybara.repository.usuario.PreferenciasUsuarioRepository;
import br.com.capybara.repository.usuario.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class PreferenciasUsuarioService {

    private PreferenciasUsuarioRepository preferenciasUsuarioRepository;

    private UsuarioRepository usuarioRepository;
    private CategoriaEventoRepository categoriaEventoRepository;

    public PreferenciasUsuarioService(PreferenciasUsuarioRepository preferenciasUsuarioRepository, UsuarioRepository usuarioRepository, CategoriaEventoRepository categoriaEventoRepository){
        this.preferenciasUsuarioRepository = preferenciasUsuarioRepository;
        this.usuarioRepository = usuarioRepository;
        this.categoriaEventoRepository = categoriaEventoRepository;
    }

    @Transactional
    public PreferenciasUsuario cadastrarPreferencias(PreferenciasUsuarioDTO preferenciasUsuarioDTO){
       var usuario = usuarioRepository.findById(preferenciasUsuarioDTO.getUsuario())
               .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com o ID: " + preferenciasUsuarioDTO.getUsuario()));
        ;
       var categoria = categoriaEventoRepository.findById(preferenciasUsuarioDTO.getCategoriaEvento())
               .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com o ID: " + preferenciasUsuarioDTO.getCategoriaEvento()));
        ;

       PreferenciasUsuario preferenciasUsuario = new PreferenciasUsuario();
       preferenciasUsuario.setUsuario(usuario);
       preferenciasUsuario.setCategoriaEvento(categoria);
       return preferenciasUsuarioRepository.save(preferenciasUsuario);
    }
}
