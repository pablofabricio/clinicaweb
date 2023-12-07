package br.sisnema.backend.clinicaweb.controllers;

import br.sisnema.backend.clinicaweb.dtos.EspecialidadeDTO;
import br.sisnema.backend.clinicaweb.services.EspecialidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/especialidades")
public class EspecialidadeController {
    @Autowired
    private EspecialidadeService service;

    @GetMapping
    public ResponseEntity<List<EspecialidadeDTO>> all() {
        return ResponseEntity.ok(service.all());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EspecialidadeDTO> find(@PathVariable Long id) {
        return ResponseEntity.ok(service.find(id));
    }

    @GetMapping(value = "/{id}/medicos")
    public ResponseEntity<EspecialidadeDTO> findMedicos(@PathVariable Long id) {
        return ResponseEntity.ok(service.findMedicos(id));
    }

    @PostMapping
    public ResponseEntity<EspecialidadeDTO> save(@RequestBody EspecialidadeDTO dto) {
        EspecialidadeDTO resultado = service.save(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(resultado.getId()).toUri();

        return ResponseEntity.created(uri).body(resultado);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EspecialidadeDTO> update(@PathVariable Long id, @RequestBody EspecialidadeDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
