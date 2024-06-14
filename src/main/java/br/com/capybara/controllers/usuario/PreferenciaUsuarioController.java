package br.com.capybara.controllers.usuario;

import br.com.capybara.dtos.usuario.PreferenciasUsuarioDTO;
import br.com.capybara.services.usuario.PreferenciasUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/preferencias")
public class PreferenciaUsuarioController {

    private PreferenciasUsuarioService preferenciasUsuarioService;
    public PreferenciaUsuarioController(PreferenciasUsuarioService preferenciasUsuarioService){
        this.preferenciasUsuarioService = preferenciasUsuarioService;
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/cadastrar")
    public ResponseEntity cadastrar(@RequestBody PreferenciasUsuarioDTO preferenciasUsuarioDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(preferenciasUsuarioService.cadastrarPreferencias(preferenciasUsuarioDTO));
    }
}
