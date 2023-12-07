package br.sisnema.backend.clinicaweb.services;

import br.sisnema.backend.clinicaweb.dtos.EspecialidadeDTO;
import br.sisnema.backend.clinicaweb.dtos.MedicoDTO;
import br.sisnema.backend.clinicaweb.entities.Especialidade;
import br.sisnema.backend.clinicaweb.entities.Medico;
import br.sisnema.backend.clinicaweb.repositories.EspecialidadeRepository;
import br.sisnema.backend.clinicaweb.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;

    @Transactional(readOnly = true)
    public List<MedicoDTO> all() {
        return repository.findAll().stream().map(x -> new MedicoDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public MedicoDTO find(Long id) {
        Medico entidade = repository.findById(id).get();

        return new MedicoDTO(entidade);
    }

    @Transactional
    public MedicoDTO save(MedicoDTO dto) {
        Medico entidade = new Medico();

        copiarDtoParaEntidade(dto, entidade);
        entidade = repository.save(entidade);

        return new MedicoDTO(entidade);
    }

    @Transactional
    public MedicoDTO update(Long id, MedicoDTO dto) {
        Medico entidade = repository.getReferenceById(id);

        copiarDtoParaEntidade(dto, entidade);
        entidade = repository.save(entidade);

        return new MedicoDTO(entidade);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private void copiarDtoParaEntidade(MedicoDTO dto, Medico entidade) {
        entidade.setNome(dto.getNome());
        entidade.setEmail(dto.getEmail());
        entidade.setCrm(dto.getCrm());
        entidade.setAtendeConvenio(dto.isAtendeConvenio());
        entidade.setEspecialidade(new Especialidade(dto.getId_especialidade()));
    }
}
