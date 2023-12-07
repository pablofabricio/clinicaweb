package br.sisnema.backend.clinicaweb.dtos;

import br.sisnema.backend.clinicaweb.entities.Endereco;
import br.sisnema.backend.clinicaweb.entities.Paciente;
import br.sisnema.backend.clinicaweb.entities.enums.Sexo;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.Instant;

public class PacienteDTO implements Serializable {
    private static  final long serialVersionUID = 1L;
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private Sexo sexo;
    private Instant dataCadastro;
    private Long id_endereco;

    public PacienteDTO() {
    }

    public PacienteDTO(Long id, String nome, String email, String cpf, Sexo sexo, Instant dataCadastro, Long id_endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.sexo = sexo;
        this.dataCadastro = dataCadastro;
        this.id_endereco = id_endereco;
    }

    public PacienteDTO(Paciente entidade) {
        this.id = entidade.getId();
        this.nome = entidade.getNome();
        this.email = entidade.getEmail();
        this.cpf = entidade.getCpf();
        this.sexo = entidade.getSexo();
        this.dataCadastro = entidade.getDataCadastro();
        this.id_endereco = entidade.getEndereco().getId();
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

    public Long getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(Long id_endereco) {
        this.id_endereco = id_endereco;
    }
}
