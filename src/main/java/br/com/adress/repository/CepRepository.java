package br.com.adress.repository;

import br.com.adress.model.CepModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CepRepository extends JpaRepository<CepModel, Long> {

    CepModel findByCep(String cep);
}