package br.com.bluetech.model;

import java.util.List;

import com.owlike.genson.annotation.JsonIgnore;

import br.bluetech.service.EleicaoService;

public class Eleicao 
{ 
	private Long id; 
	private Long empreendimento_id; 
	private Long usuario_id;	
	
	
	public void inserirVoto() 
	{
		EleicaoService service = new EleicaoService();
		this.setId(0L);
		service.inserir(this);
		 
	}
	
	public List<Eleicao> listar()
	{
		return new EleicaoService().listar();
	}
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getEmpreendimento_id() {
		return empreendimento_id;
	}
	public void setEmpreendimento_id(Long empreendimento_id) {
		this.empreendimento_id = empreendimento_id;
	}
	public Long getUsuario_id() {
		return usuario_id;
	}
	public void setUsuario_id(Long usuario_id) {
		this.usuario_id = usuario_id;
	}


	@Override
	public String toString() {
		return "Eleicao [id=" + id + ", empreendimento_id=" + empreendimento_id + ", usuario_id=" + usuario_id + "]";
	}
	
	
	 

}
