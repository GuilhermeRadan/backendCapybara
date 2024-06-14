package br.com.capybara.models.usuario;

import br.com.capybara.enums.TipoUusario;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Table(name = "usuario")
@Entity
public class Usuario {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)

    private String email;
    @Column(nullable = false)

    private String senha;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<PreferenciasUsuario> preferencias = new HashSet<>();


    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Organizador organizador;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Organizador getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Organizador organizador) {
        this.organizador = organizador;
    }

    public Set<PreferenciasUsuario> getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(Set<PreferenciasUsuario> preferencias) {
        this.preferencias = preferencias;
    }
}
