package br.com.capybara.models.usuario;

import jakarta.persistence.*;

@Entity
@Table(name = "organizador")
public class Organizador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "razao_social", nullable = false)
    private String razaoSocial;
    @Column
    private Integer telefone;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;


}
