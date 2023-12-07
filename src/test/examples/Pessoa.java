package br.sisnema.backend.clinicaweb.examples;

import javax.persistence.*;

@Entity
@Table(name = "tb_pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    @OneToOne(mappedBy = "pessoa")
    private Veiculo veiculo;
}
