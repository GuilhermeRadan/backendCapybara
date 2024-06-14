package br.com.capybara.services.usuario;

import br.com.capybara.dtos.evento.EventoResumoDTO;
import br.com.capybara.dtos.usuario.UsuarioDto;
import br.com.capybara.models.evento.Evento;
import br.com.capybara.models.usuario.Usuario;
import br.com.capybara.repository.usuario.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    private ModelMapper modelMapper;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, ModelMapper modelMapper){
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
    }

    public Usuario cadastrar(UsuarioDto usuarioDto){
        Usuario usuarioEntity = new Usuario();

        usuarioEntity.setNome(usuarioDto.getNome());
        usuarioEntity.setEmail(usuarioDto.getEmail());
        usuarioEntity.setSenha(usuarioDto.getSenha());
        return usuarioRepository.save(usuarioEntity);
    }




}
