package br.com.bluetech.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.bluetech.service.EmpreendimentoService;

public class Empreendimento  
{
	 
	private Long id;
	private String descricao;
	private String img;
	private int votos;
	private List<Usuario> eleitores = new ArrayList<Usuario>(); 
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
 
	 
	
	
	public List<Empreendimento> lista()
	{
		return new EmpreendimentoService().listar();
	}
	
	
	//retorna quantidade de do empreendimento
	public int getVotos() 
	{
		int i = 0;
		Eleicao eleicao = new Eleicao();		
		for (Eleicao e : eleicao.listar()) 
		{			 
			if(this.id.hashCode() == e.getEmpreendimento_id().hashCode() ) 
			{
				i++;
			}			
		}		
		
		return i;
	}
	
	
	public void setVotos(int votos) {
		this.votos = votos;
	}
	public List<Usuario> getEleitores() 
	{
		Usuario usuario = new Usuario();
		Eleicao eleicao = new Eleicao();
		List<Usuario> list = new ArrayList<Usuario>();
		
		for (Eleicao e : eleicao.listar()) 
		{
			if(this.id.hashCode() == e.getEmpreendimento_id().hashCode()) 
			{
				 for (Usuario u: usuario.lista()) 
				 {
					 if(u.getId().hashCode() == e.getUsuario_id().hashCode()) 
					 {
						 list.add(u); // adiciona usuario
					 }
					
				 }
				
			}
			
		}
		
		
		
		return list;
	}
	public void setEleitores(List<Usuario> eleitores) {
		this.eleitores = eleitores;
	}
	
	
	
	

}
