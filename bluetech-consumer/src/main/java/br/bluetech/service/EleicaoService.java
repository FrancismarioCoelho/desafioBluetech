package br.bluetech.service;

import java.util.List;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.LoggingFilter;

import br.com.bluetech.model.Eleicao;
import br.com.bluetech.model.Empreendimento;
import br.com.bluetech.model.Usuario;

public class EleicaoService 
{
	String url = "http://localhost:8080/eleicao";

	//post
	public Eleicao inserir(Eleicao eleicao) 
	{
		Client client = Client.create();
		client.addFilter(new LoggingFilter(System.out));
		WebResource resource = client.resource(url);
	 	return resource.path("/inserir").post(new GenericType<Eleicao>() {},eleicao);
	}
	
	//faz uma get na api retornando uma lista  do tipo Eleição
	public List<Eleicao> listar() 
	{
		
		Client client = Client.create();
		WebResource resource = client.resource(this.url);
		List<Eleicao> listEleicao = resource.path("/listar")
				.get(new GenericType<List<Eleicao>>() {});

		return listEleicao;

	}
	
	
	
}
