package br.com.capybara.services.evento;

import br.com.capybara.dtos.evento.EventoDTO;
import br.com.capybara.dtos.evento.EventoResumoDTO;
import br.com.capybara.models.evento.Evento;
import br.com.capybara.repository.evento.CategoriaEventoRepository;
import br.com.capybara.repository.evento.EventoRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventoService {
    private CategoriaEventoRepository categoriaEventoRepository;
    private EventoRepository eventoRepository;


    private ModelMapper modelMapper;
    @Autowired
    public EventoService(EventoRepository eventoRepository, CategoriaEventoRepository categoriaEventoRepository,  ModelMapper modelMapper){
        this.eventoRepository = eventoRepository;
        this.categoriaEventoRepository = categoriaEventoRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public Evento cadastrar( EventoDTO eventoDto){
        Evento evento = new Evento();
        evento.setTitulo(eventoDto.getTitulo());
        evento.setDescricao(eventoDto.getDescricao());
        evento.setDataHoraInicio(eventoDto.getDataHoraInicio());
        evento.setDataHoraTermino(eventoDto.getDataHoraTermino());
        evento.setLatitude(eventoDto.getLatitude());
        evento.setLongetude(eventoDto.getLongetude());


        return eventoRepository.save(evento);


    }

    public List<EventoDTO> listarEventos(){
        List<Evento> eventos = eventoRepository.findAll();
        return eventos.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<EventoResumoDTO> listarResumoEvento(){
        List<Evento> eventos = eventoRepository.findAll();
        return eventos.stream()
                .map(this::convertToEventoResumoDto)
                .collect(Collectors.toList());

    }

    private EventoResumoDTO convertToEventoResumoDto(Evento evento) {
        return modelMapper.map(evento, EventoResumoDTO.class);
    }



    private EventoDTO toDTO(Evento evento) {
        EventoDTO dto = new EventoDTO();
        dto.setTitulo(evento.getTitulo());
        dto.setDescricao(evento.getDescricao());
        dto.setDataHoraInicio(evento.getDataHoraInicio());
        dto.setDataHoraTermino(evento.getDataHoraTermino());
        dto.setLatitude(evento.getLatitude());
        dto.setLongetude(evento.getLongetude());
        dto.setCategoriaEvento(evento.getCategoriaEvento());


        return dto;


    }
}
