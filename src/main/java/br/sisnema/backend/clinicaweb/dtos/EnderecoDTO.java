package br.sisnema.backend.clinicaweb.dtos;

import br.sisnema.backend.clinicaweb.entities.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDTO implements Serializable {
    private static  final long serialVersionUID = 1L;
    private Long id;
    private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;
    private List<FuncionarioDTO> funcionarios = new ArrayList<>();
    private List<PacienteDTO> pacientes = new ArrayList<>();

    public EnderecoDTO() {
    }

    public EnderecoDTO(Long id, String rua, String numero, String complemento, String bairro, String cep, String cidade, String estado) {
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }

    public EnderecoDTO(Endereco entidade) {
        id = entidade.getId();
        rua = entidade.getRua();
        numero = entidade.getNumero();
        complemento = entidade.getComplemento();
        bairro = entidade.getBairro();
        cep = entidade.getCep();
        cidade = entidade.getCidade();
        estado = entidade.getEstado();
    }

    //public EnderecoDTO(Endereco entidade, List<Funcionario> funcionarios) {
    //    this(entidade);
    //    funcionarios.forEach(funcionario -> this.funcionarios.add(new FuncionarioDTO(funcionario)));
    //}

    public EnderecoDTO(Endereco entidade, List<Paciente> pacientes) {
        this(entidade);
        pacientes.forEach(paciente -> this.pacientes.add(new PacienteDTO(paciente)));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<FuncionarioDTO> getFuncionarios() {
        return funcionarios;
    }

    public List<PacienteDTO> getPacientes() {
        return pacientes;
    }
}
