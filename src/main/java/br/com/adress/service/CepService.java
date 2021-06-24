package br.com.adress.service;

import br.com.adress.dto.DadosEndereco;
import br.com.adress.model.CepModel;
import br.com.adress.repository.CepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CepService {

    @Autowired
    private CepRepository cepRepository;

    public void save(DadosEndereco dadosEndereco) {

        cepRepository.save(CepModel.builder()
                .cep(dadosEndereco.getCep())
                .rua(dadosEndereco.getRua())
                .bairro(dadosEndereco.getBairro())
                .cidade(dadosEndereco.getCidade())
                .estado(dadosEndereco.getEstado())
                .pais(dadosEndereco.getPais())
                .build());
    }

    public DadosEndereco buscaCep(String cep) {

        CepModel endereco = cepRepository.findByCep(cep);

        return DadosEndereco
                .builder()
                .cep(endereco.getCep())
                .rua(endereco.getRua())
                .bairro(endereco.getBairro())
                .cidade(endereco.getCidade())
                .estado(endereco.getEstado())
                .pais(endereco.getPais())
                .build();
    }
}

