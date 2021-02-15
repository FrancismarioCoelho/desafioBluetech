package br.bluetech.service;

import java.util.List;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import br.com.bluetech.model.Empreendimento;
import br.com.bluetech.model.Usuario;

public class EmpreendimentoService 
{
	String url = "http://localhost:8080/empreendimento";
	
	public List<Empreendimento> listar() 
	{
			Client client = Client.create();
			WebResource resource = client.resource(url);

			List<Empreendimento> listEmp = resource.path("/listar")
					.get(new GenericType<List<Empreendimento>>() {});			

			return listEmp;		
	}
	
	

}
