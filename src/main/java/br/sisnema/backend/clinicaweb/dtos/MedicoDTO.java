package br.sisnema.backend.clinicaweb.dtos;

import br.sisnema.backend.clinicaweb.entities.Medico;

import java.io.Serializable;

public class MedicoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String email;
    private String crm;
    private boolean atendeConvenio;
    private Long id_especialidade;

    public MedicoDTO() {
    }

    public MedicoDTO(Long id, String nome, String email, String crm, boolean atendeConvenio, Long id_especialidade) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.crm = crm;
        this.atendeConvenio = atendeConvenio;
        this.id_especialidade = id_especialidade;
    }

    public MedicoDTO(Medico entidade) {
        id = entidade.getId();
        nome = entidade.getNome();
        email = entidade.getEmail();
        crm = entidade.getCrm();
        atendeConvenio = entidade.isAtendeConvenio();
        id_especialidade = entidade.getEspecialidade().getId();
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

    public Long getId_especialidade() {
        return id_especialidade;
    }

    public void setId_especialidade(Long id_especialidade) {
        this.id_especialidade = id_especialidade;
    }
}
