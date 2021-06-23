package br.com.adress.controller;

import br.com.adress.dto.CepRequest;
import br.com.adress.dto.DefaultResponse;
import br.com.adress.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/cep")
public class CepController {

    @Autowired
    private CepService cepService;

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<DefaultResponse> cadastrar(@Valid @RequestBody CepRequest cepRequest) {
        cepService.process(cepRequest);
        return new ResponseEntity<>(DefaultResponse
                .builder()
                .message("Dados registrados com sucesso")
                .build(), HttpStatus.CREATED);
    }
}