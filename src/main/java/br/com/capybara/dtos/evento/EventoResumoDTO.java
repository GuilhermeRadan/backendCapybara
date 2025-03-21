package br.com.capybara.dtos.evento;

public class EventoResumoDTO {

    private String titulo;

    private String descricao;

    public EventoResumoDTO(){}

    public EventoResumoDTO (String titulo, String descricao){
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
