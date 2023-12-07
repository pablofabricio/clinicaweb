package br.sisnema.backend.clinicaweb.services;

import br.sisnema.backend.clinicaweb.dtos.EnderecoDTO;
import br.sisnema.backend.clinicaweb.dtos.EspecialidadeDTO;
import br.sisnema.backend.clinicaweb.entities.Endereco;
import br.sisnema.backend.clinicaweb.entities.Especialidade;
import br.sisnema.backend.clinicaweb.repositories.EnderecoRepository;
import br.sisnema.backend.clinicaweb.repositories.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    public List<EnderecoDTO> all() {
        return repository.findAll().stream().map(x -> new EnderecoDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EnderecoDTO find(Long id) {
        Endereco entidade = repository.findById(id).get();

        return new EnderecoDTO(entidade);
    }

    @Transactional
    public EnderecoDTO save(EnderecoDTO dto) {
        Endereco entidade = new Endereco();

        copiarDtoParaEntidade(dto, entidade);
        entidade = repository.save(entidade);

        return new EnderecoDTO(entidade);
    }

    @Transactional
    public EnderecoDTO update(Long id, EnderecoDTO dto) {
        Endereco entidade = repository.getReferenceById(id);

        copiarDtoParaEntidade(dto, entidade);
        entidade = repository.save(entidade);

        return new EnderecoDTO(entidade);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private void copiarDtoParaEntidade(EnderecoDTO dto, Endereco entidade) {
        entidade.setRua(dto.getRua());
        entidade.setNumero(dto.getNumero());
        entidade.setComplemento(dto.getComplemento());
        entidade.setBairro(dto.getBairro());
        entidade.setCep(dto.getCep());
        entidade.setCidade(dto.getCidade());
        entidade.setEstado(dto.getEstado());
    }
}
