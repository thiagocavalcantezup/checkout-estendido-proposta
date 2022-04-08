package br.com.zup.checkoutestendidoproposta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.checkoutestendidoproposta.models.Proposta;

public interface PropostaRepository extends JpaRepository<Proposta, Long> {

}
