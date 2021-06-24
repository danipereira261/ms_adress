package br.com.adress.controller;

import br.com.adress.dto.DadosEndereco;
import br.com.adress.dto.DefaultResponse;
import br.com.adress.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/cep")
public class CepController {

    @Autowired
    private CepService cepService;

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<DefaultResponse> cadastrar(@Valid @RequestBody DadosEndereco dadosEndereco) {
        cepService.save(dadosEndereco);
        return new ResponseEntity<>(DefaultResponse
                .builder()
                .message("Dados registrados com sucesso")
                .build(), HttpStatus.CREATED);
    }

    @GetMapping(value = "/listar-enderecos/{cep}")
    public ResponseEntity<DadosEndereco> listarEnderecos(@PathVariable String cep) {
        return new ResponseEntity<>(cepService.buscaCep(cep), HttpStatus.OK);

    }
}