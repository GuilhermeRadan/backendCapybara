package br.com.capybara.controllers.usuario;

import br.com.capybara.dtos.usuario.UsuarioDto;
import br.com.capybara.services.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;
    @Autowired
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/cadastrar")
    public ResponseEntity cadastraUsuario(@RequestBody UsuarioDto usuarioDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.cadastrar(usuarioDto));
    }
}
