package br.sisnema.backend.clinicaweb.controllers;

import br.sisnema.backend.clinicaweb.dtos.EnderecoDTO;
import br.sisnema.backend.clinicaweb.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/enderecos")
public class EnderecoController {
    @Autowired
    private EnderecoService service;

    @GetMapping
    public List<EnderecoDTO> all() {
        return service.all();
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<EnderecoDTO> find(@PathVariable Long id) {
        return ResponseEntity.ok(service.find(id));
    }

    @PostMapping
    public ResponseEntity<EnderecoDTO> save(@RequestBody EnderecoDTO dto) {
        EnderecoDTO resultado = service.save(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(resultado.getId()).toUri();

        return ResponseEntity.created(uri).body(resultado);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EnderecoDTO> update(@PathVariable Long id, @RequestBody EnderecoDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
