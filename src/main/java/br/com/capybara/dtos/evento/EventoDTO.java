package br.com.capybara.dtos.evento;

import br.com.capybara.models.evento.CategoriaEvento;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class EventoDTO {

    private String titulo;
    private String descricao;

    private LocalDateTime dataHoraInicio;

    private LocalDateTime dataHoraTermino;

    private Double latitude;

    private Double Longetude;


    private CategoriaEvento categoriaEvento;

    public EventoDTO(){}

    public EventoDTO(String titulo, String descricao, LocalDateTime dataHoraInicio, LocalDateTime dataHoraTermino, Double latitude, Double longetude, CategoriaEvento categoriaEvento) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraTermino = dataHoraTermino;
        this.latitude = latitude;
        Longetude = longetude;
        this.categoriaEvento = categoriaEvento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public LocalDateTime getDataHoraTermino() {
        return dataHoraTermino;
    }

    public void setDataHoraTermino(LocalDateTime dataHoraTermino) {
        this.dataHoraTermino = dataHoraTermino;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongetude() {
        return Longetude;
    }

    public void setLongetude(Double longetude) {
        Longetude = longetude;
    }

    public CategoriaEvento getCategoriaEvento() {
        return categoriaEvento;
    }

    public void setCategoriaEvento(CategoriaEvento categoriaEvento) {
        this.categoriaEvento = categoriaEvento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
