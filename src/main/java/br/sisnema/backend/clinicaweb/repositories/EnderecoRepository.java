package br.sisnema.backend.clinicaweb.repositories;

import br.sisnema.backend.clinicaweb.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
