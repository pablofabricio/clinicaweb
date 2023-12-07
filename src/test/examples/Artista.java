package br.sisnema.backend.clinicaweb.examples;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_artista")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private boolean banda;
    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;

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

    public boolean isBanda() {
        return banda;
    }

    public void setBanda(boolean banda) {
        this.banda = banda;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Artista artista = (Artista) o;

        return Objects.equals(id, artista.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Artista{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", banda=" + banda +
                ", pais=" + pais +
                '}';
    }
}
