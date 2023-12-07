package br.sisnema.backend.clinicaweb.dtos;

import br.sisnema.backend.clinicaweb.entities.Endereco;
import br.sisnema.backend.clinicaweb.entities.Funcionario;

import java.io.Serializable;

public class FuncionarioDTO implements Serializable {
    private static  final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private Long id_endereco;

    public FuncionarioDTO() {
    }

    public FuncionarioDTO(Long id, String nome, String email, String cpf, Long id_endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.id_endereco = id_endereco;
    }

    public FuncionarioDTO(Funcionario entidade) {
        this.id = entidade.getId();
        this.nome = entidade.getNome();
        this.email = entidade.getEmail();
        this.cpf = entidade.getCpf();
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

    public Long getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(Long id_endereco) {
        this.id_endereco = id_endereco;
    }
}
