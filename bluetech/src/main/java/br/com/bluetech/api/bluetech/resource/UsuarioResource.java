package br.com.bluetech.api.bluetech.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.bluetech.api.bluetech.model.Eleicao;
import br.com.bluetech.api.bluetech.model.Usuario;
import br.com.bluetech.api.bluetech.repository.UsuarioRepository;

@CrossOrigin
@RestController
@RequestMapping("/usuario")
public class UsuarioResource 
{
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/listar")
	public List<Usuario> listar()
	{
		return usuarioRepository.findAll(); 
	}
	
	@CrossOrigin
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping("/inserir")
	public ResponseEntity<Usuario> inserir(@RequestBody  Usuario usuario, HttpServletResponse response) 
	{		
		Usuario usuarioSalvo = usuarioRepository.save(usuario);
		URI uri =ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(usuarioSalvo.getId()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(usuarioSalvo);
	}	

}
