package br.sisnema.backend.clinicaweb.controllers;

import br.sisnema.backend.clinicaweb.dtos.MedicoDTO;
import br.sisnema.backend.clinicaweb.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/medicos")
public class MedicoController {
    @Autowired
    private MedicoService service;

    @GetMapping
    public ResponseEntity<List<MedicoDTO>> all() {
        return ResponseEntity.ok(service.all());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MedicoDTO> find(@PathVariable Long id) {
        return ResponseEntity.ok(service.find(id));
    }

    @PostMapping
    public ResponseEntity<MedicoDTO> save(@RequestBody MedicoDTO dto) {
        MedicoDTO resultado = service.save(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(resultado.getId()).toUri();

        return ResponseEntity.created(uri).body(resultado);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MedicoDTO> update(@PathVariable Long id, @RequestBody MedicoDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
