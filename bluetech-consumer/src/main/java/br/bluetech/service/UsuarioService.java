package br.bluetech.service;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.owlike.genson.internal.asm.Type;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.LoggingFilter;

import br.com.bluetech.model.Eleicao;
import br.com.bluetech.model.Empreendimento;
import br.com.bluetech.model.Usuario;

public class UsuarioService {

	private String url = "http://localhost:8080/usuario";

	// post
	public Usuario inserir(Usuario usuario) 
	{
		Client client = Client.create();
		client.addFilter(new LoggingFilter(System.out));
		WebResource resource = client.resource(url);
		return resource.path("/inserir").post(new GenericType<Usuario>() {}, usuario);
	}

	// faz uma chamado no webservice retornando um recurso usuario
	public List<Usuario> listar() {

		Client client = Client.create();
		WebResource resource = client.resource(this.url);
		List<Usuario> listUsuarios = resource.path("/listar").get(new GenericType<List<Usuario>>() {
		});

		return listUsuarios;

	}

	public Usuario buscaUsuario(Usuario usuario) {

		for (Usuario user : this.listar()) {

			if (user.getEmail().equals(usuario.getEmail())) {
				usuario = user;
			}
		}

		return usuario;
	}

}
