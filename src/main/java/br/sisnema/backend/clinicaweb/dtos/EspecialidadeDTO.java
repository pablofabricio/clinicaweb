package br.sisnema.backend.clinicaweb.dtos;

import br.sisnema.backend.clinicaweb.entities.Especialidade;
import br.sisnema.backend.clinicaweb.entities.Medico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EspecialidadeDTO implements Serializable {
    private static  final long serialVersionUID = 1L;
    private Long id;
    private String nome;
    private String descricao;
    private List<MedicoDTO> medicos = new ArrayList<>();

    public EspecialidadeDTO() {
    }

    public EspecialidadeDTO(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public EspecialidadeDTO(Especialidade entidade, List<Medico> medicos) {
        this(entidade);
        medicos.forEach(med -> this.medicos.add(new MedicoDTO(med)));
    }

    public EspecialidadeDTO(Especialidade entidade) {
        this.id = entidade.getId();
        this.nome = entidade.getNome();
        this.descricao = entidade.getDescricao();
    }

    public List<MedicoDTO> getMedicos() {
        return this.medicos;
    }

    public void setMedicos(List<MedicoDTO> medicos) {
        this.medicos = medicos;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
