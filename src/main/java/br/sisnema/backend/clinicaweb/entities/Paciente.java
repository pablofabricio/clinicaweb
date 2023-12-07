package br.sisnema.backend.clinicaweb.entities;

import br.sisnema.backend.clinicaweb.entities.enums.Sexo;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_paciente")
public class Paciente implements Serializable {
    private static  final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cpf;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    private Instant dataCadastro;

    @ManyToOne
    @JoinColumn(name="id_endereco")
    private Endereco endereco;

    public Paciente() {}

    public Paciente(Long id) {
        this.id = id;
    }

    public Paciente(Long id, String nome, String email, String cpf, Sexo sexo, Instant dataCadastro, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.sexo = sexo;
        this.dataCadastro = dataCadastro;
        this.endereco = endereco;
    }

    public Long getId() {
        return this.id;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Instant getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Instant dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Paciente paciente = (Paciente) o;

        return Objects.equals(id, paciente.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", sexo=" + sexo +
                ", dataCadastro=" + dataCadastro +
                ", endereco=" + endereco +
                '}';
    }
}
