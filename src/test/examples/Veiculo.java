package br.sisnema.backend.clinicaweb.examples;

import javax.persistence.*;

@Entity
@Table(name = "tb_veiculo")
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private String placa;
    @OneToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
}
