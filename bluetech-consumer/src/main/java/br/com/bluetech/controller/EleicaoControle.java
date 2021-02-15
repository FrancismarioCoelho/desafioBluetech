package br.com.bluetech.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.model.chart.PieChartModel;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.pie.PieChartDataSet;

import br.com.bluetech.model.Eleicao;
import br.com.bluetech.model.Empreendimento;

@Named
@SessionScoped
public class EleicaoControle implements Serializable 
{
	
	private int id_empreendimento;
	private int id_usuario;
	private List<Empreendimento> empreendimentos =  new ArrayList<Empreendimento>();
	private Eleicao eleicao = new Eleicao();
	private int total_votos;
	@Inject
	private UsuarioControle usuarioControle;
	
	
	
	
	
	public void votar() 
	{
		 Empreendimento empreendimento = new Empreendimento();
		 
		 Eleicao eleicao = new Eleicao();
		 eleicao.setEmpreendimento_id((long) this.getId_empreendimento());
		 eleicao.setUsuario_id((long) this.getId_usuario());		
		 eleicao.inserirVoto();
		
		
	}
	
	
	
	public List<Empreendimento> getEmpreendimentos()
	{
		return new Empreendimento().lista();
	}

	
	
	public void setEmpreendimentos(List<Empreendimento> empreendimentos) 
	{
		this.empreendimentos = empreendimentos;
	}



	public int getId_empreendimento() 
	{
		 
		
		return id_empreendimento;
	}



	public void setId_empreendimento(int id_empreendimento) 
	{
		this.id_empreendimento = id_empreendimento;
	}



	public int getId_usuario() {
		return id_usuario;
	}



	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}



	public Eleicao getEleicao() {
		return eleicao;
	}



	public void setEleicao(Eleicao eleicao) {
		this.eleicao = eleicao;
	}


 



	public UsuarioControle getUsuarioControle() {
		return usuarioControle;
	}



	public void setUsuarioControle(UsuarioControle usuarioControle) {
		this.usuarioControle = usuarioControle;
	}



	public int getTotal_votos() 
	{
		
		
		return new Eleicao().listar().size();
	}



	public void setTotal_votos(int total_votos) {
		this.total_votos = total_votos;
	}

	
	
	

	
	
	

}
