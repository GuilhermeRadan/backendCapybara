package br.com.capybara.controllers.evento;

import br.com.capybara.dtos.evento.EventoDTO;
import br.com.capybara.dtos.evento.EventoResumoDTO;
import br.com.capybara.services.evento.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evento")
public class EventoController {

    private EventoService eventoService;
    @Autowired
    public EventoController(EventoService eventoService){
        this.eventoService = eventoService;
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/cadastrar")
    public ResponseEntity cadastrarEvento(@RequestBody EventoDTO eventoDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(eventoService.cadastrar(eventoDto));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/listar")
    public List<EventoDTO> listarEvento(){
        return eventoService.listarEventos();
    }

    @GetMapping("/listar-evento-resumo")
    public List<EventoResumoDTO> listarEventoResumo(){
        return eventoService.listarResumoEvento();
    }
}
