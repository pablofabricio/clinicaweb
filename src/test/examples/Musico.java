package br.sisnema.backend.clinicaweb.examples;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_musico")
public class Musico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;
    private LocalDate dataNasc;
    @ManyToMany
    @JoinTable(
            name = "tb_musico_instrumento",
            joinColumns = @JoinColumn(name = "musico_id"),
            inverseJoinColumns = @JoinColumn(name = "instrumento_id")
    )
    private Set<Instrumento> instrumentosSet = new HashSet<>();
}
