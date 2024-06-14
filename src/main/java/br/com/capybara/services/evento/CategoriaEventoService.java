package br.com.capybara.services.evento;

import br.com.capybara.dtos.evento.CategoriaEventoDTO;
import br.com.capybara.models.evento.CategoriaEvento;
import br.com.capybara.repository.evento.CategoriaEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaEventoService {

    private CategoriaEventoRepository categoriaEventoRepository;
    @Autowired
    public CategoriaEventoService(CategoriaEventoRepository categoriaEventoRepository){
        this.categoriaEventoRepository = categoriaEventoRepository;
    }

    public CategoriaEvento cadastrar(CategoriaEventoDTO categoriaEventoDto){
        CategoriaEvento categoria = new CategoriaEvento();
        categoria.setNome(categoriaEventoDto.getNome());
        return categoriaEventoRepository.save(categoria);
    }

    public List<CategoriaEventoDTO> listarCategoria(){
        List<CategoriaEvento> categoriaEventos = categoriaEventoRepository.findAll();
        return categoriaEventos.stream().map(this::toDTO).collect(Collectors.toList());

    }

    public CategoriaEventoDTO toDTO(CategoriaEvento categoriaEvento){
        CategoriaEventoDTO categoriaDTO = new CategoriaEventoDTO();
        categoriaDTO.setNome(categoriaEvento.getNome());
        categoriaDTO.setId(categoriaEvento.getId());
        return categoriaDTO;
    }
}
