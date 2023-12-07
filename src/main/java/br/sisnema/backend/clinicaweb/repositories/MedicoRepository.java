package br.sisnema.backend.clinicaweb.repositories;

import br.sisnema.backend.clinicaweb.entities.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
