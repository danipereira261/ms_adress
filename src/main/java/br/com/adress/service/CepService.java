package br.com.adress.service;

import br.com.adress.dto.CepRequest;
import br.com.adress.model.CepModel;
import br.com.adress.repository.CepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CepService {

    @Autowired
    private CepRepository cepRepository;

    public void process(CepRequest cepRequest) {

        CepModel cepModel = cepRepository.findByCep(cepRequest.getCep());

        cepRepository.save(CepModel.builder()
                .cep(cepRequest.getCep())
                .rua(cepRequest.getRua())
                .bairro(cepRequest.getBairro())
                .cidade(cepRequest.getCidade())
                .estado(cepRequest.getEstado())
                .pais(cepRequest.getPais())
                .build());
    }
}
