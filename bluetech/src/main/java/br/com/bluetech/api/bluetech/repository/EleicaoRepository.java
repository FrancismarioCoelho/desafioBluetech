package br.com.bluetech.api.bluetech.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bluetech.api.bluetech.model.Eleicao;

public interface EleicaoRepository extends JpaRepository<Eleicao, Long>
{
	

}
