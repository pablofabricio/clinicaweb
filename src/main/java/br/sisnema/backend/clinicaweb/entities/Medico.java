package br.sisnema.backend.clinicaweb.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_medico")
public class Medico implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    @Column(updatable = false)
    private String crm;
    private boolean atendeConvenio;

    @ManyToOne
    @JoinColumn(name = "id_especialidade")
    private Especialidade especialidade;

    public Medico() {
    }

    public Medico(Long id, String nome, String email, String crm, boolean atendeConvenio, Especialidade especialidade) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.crm = crm;
        this.atendeConvenio = atendeConvenio;
        this.especialidade = especialidade;
    }

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

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public boolean isAtendeConvenio() {
        return atendeConvenio;
    }

    public void setAtendeConvenio(boolean atendeConvenio) {
        this.atendeConvenio = atendeConvenio;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Medico medico = (Medico) o;

        return Objects.equals(id, medico.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", crm='" + crm + '\'' +
                ", atendeConvenio=" + atendeConvenio +
                ", especialidade=" + especialidade +
                '}';
    }
}
