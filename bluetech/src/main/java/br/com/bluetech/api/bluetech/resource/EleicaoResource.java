package br.com.bluetech.api.bluetech.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.bluetech.api.bluetech.model.Eleicao;
import br.com.bluetech.api.bluetech.repository.EleicaoRepository;

@CrossOrigin
@RestController
@RequestMapping("/eleicao")
public class EleicaoResource
{
	@Autowired
	private EleicaoRepository eleicaoRepository;
	
	@RequestMapping("/listar")
	public List<Eleicao> listar()
	{
		return eleicaoRepository.findAll();
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping("/inserir")
	public ResponseEntity<Eleicao> inserir(@RequestBody  Eleicao eleicao, HttpServletResponse response) 
	{		
		Eleicao votoSalvo = eleicaoRepository.save(eleicao);
		URI uri =ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(votoSalvo.getId()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(votoSalvo);
	}	
	
	
	
	

}
