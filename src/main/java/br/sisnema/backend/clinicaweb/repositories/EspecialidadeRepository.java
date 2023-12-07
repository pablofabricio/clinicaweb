package br.sisnema.backend.clinicaweb.repositories;

import br.sisnema.backend.clinicaweb.entities.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long> {
}
