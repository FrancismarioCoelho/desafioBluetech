package br.com.bluetech.api.bluetech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bluetech.api.bluetech.model.Empreendimento;

public interface EmpreendimentoRepository extends JpaRepository<Empreendimento, Long> {

}
