package br.sisnema.backend.clinicaweb.services;

import br.sisnema.backend.clinicaweb.dtos.EspecialidadeDTO;
import br.sisnema.backend.clinicaweb.entities.Especialidade;
import br.sisnema.backend.clinicaweb.repositories.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EspecialidadeService {

    @Autowired
    private EspecialidadeRepository repository;

    @Transactional(readOnly = true)
    public List<EspecialidadeDTO> all() {
        return repository.findAll().stream().map(x -> new EspecialidadeDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EspecialidadeDTO find(Long id) {
        Especialidade entidade = repository.findById(id).get();

        return new EspecialidadeDTO(entidade);
    }

    @Transactional(readOnly = true)
    public EspecialidadeDTO findMedicos(Long id) {
        Especialidade entidade = repository.findById(id).get();

        return new EspecialidadeDTO(entidade, entidade.getMedicos());
    }

    @Transactional
    public EspecialidadeDTO save(EspecialidadeDTO dto) {
        Especialidade entidade = new Especialidade();

        copiarDtoParaEntidade(dto, entidade);
        entidade = repository.save(entidade);

        return new EspecialidadeDTO(entidade);
    }

    @Transactional
    public EspecialidadeDTO update(Long id, EspecialidadeDTO dto) {
        Especialidade entidade = repository.getReferenceById(id);

        copiarDtoParaEntidade(dto, entidade);
        entidade = repository.save(entidade);

        return new EspecialidadeDTO(entidade);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private void copiarDtoParaEntidade(EspecialidadeDTO dto, Especialidade entidade) {
        entidade.setNome(dto.getNome());
        entidade.setDescricao(dto.getDescricao());
    }
}
