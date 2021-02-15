package br.com.bluetech.api.bluetech.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bluetech.api.bluetech.model.Empreendimento;
import br.com.bluetech.api.bluetech.repository.EmpreendimentoRepository;

@CrossOrigin
@RestController
@RequestMapping("/empreendimento")
public class EmpreendimentoResource 
{
	@Autowired
	private EmpreendimentoRepository empreendimentoRepository;
	
	@GetMapping("/listar")
	public List<Empreendimento> listar()
	{
		return empreendimentoRepository.findAll();
	}

}
