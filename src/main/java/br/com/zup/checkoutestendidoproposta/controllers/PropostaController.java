package br.com.zup.checkoutestendidoproposta.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.checkoutestendidoproposta.models.Proposta;
import br.com.zup.checkoutestendidoproposta.models.PropostaDTO;
import br.com.zup.checkoutestendidoproposta.repositories.PropostaRepository;

@RestController
@RequestMapping(PropostaController.BASE_URI)
public class PropostaController {

    public final static String BASE_URI = "/propostas";

    private final PropostaRepository propostaRepository;

    public PropostaController(PropostaRepository propostaRepository) {
        this.propostaRepository = propostaRepository;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid PropostaDTO propostaDTO,
                                       UriComponentsBuilder uriComponentsBuilder) {
        Proposta proposta = propostaRepository.save(propostaDTO.toModel());

        URI location = uriComponentsBuilder.path(BASE_URI + "/{id}")
                                           .buildAndExpand(proposta.getId())
                                           .toUri();

        return ResponseEntity.created(location).build();
    }

}
