package br.sisnema.backend.clinicaweb.examples;

import javax.persistence.*;

@Entity
@Table(name = "tb_instrumento")
public class Instrumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String obs;
}
