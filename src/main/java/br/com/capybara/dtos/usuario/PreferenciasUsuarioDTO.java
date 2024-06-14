package br.com.capybara.dtos.usuario;

public class PreferenciasUsuarioDTO {
    private Long categoriaEvento;

    private Long usuario;

    public PreferenciasUsuarioDTO(){}

    public PreferenciasUsuarioDTO(Long categoriaEvento, Long usuario) {
        this.categoriaEvento = categoriaEvento;
        this.usuario = usuario;
    }

    public Long getCategoriaEvento() {
        return categoriaEvento;
    }

    public void setCategoriaEvento(Long categoriaEvento) {
        this.categoriaEvento = categoriaEvento;
    }

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }
}
