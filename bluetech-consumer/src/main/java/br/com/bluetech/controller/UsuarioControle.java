package br.com.bluetech.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.bluetech.service.util.Util;
import br.com.bluetech.model.Usuario;

@Named
@SessionScoped
public class UsuarioControle implements Serializable {

	private String nome;
	private String email;
	private String senha;	
	private Usuario usuario;
	
	
	@RequestScoped
	public void inserir() 
	{
		//utilitario
		Util msg = new Util();
		
		usuario = new Usuario();
		
		try {
			if(this.nome.length() > 4 && this.email.length() > 4  && this.senha.length() > 4 ) 
			{
				usuario.setNome(this.nome);
				usuario.setEmail(this.email);
				usuario.setSenha(this.senha);				
				
			//verifica se existe e-mail cadastrado	
			if(!usuario.verificarEmail()) 
			{
				if(usuario.inserir().getId() != null) 
				{
					msg.mensagemSucesso("Cadastro realizado com sucesso");	
					this.setEmail("");
					this.setSenha("");
					this.setNome("");
				}				
			}
			else 
			{
				
				msg.mensagemErro("O e-mail informado já possui cadastro...");
			}
				
				
			}
			else 
			{
				msg.mensagemErro("Informe nome, email e senha  deve conter no minimo 4 caracteres!");				 
			}
		} catch (Exception e)
		{
			msg.mensagemErro("NÃO FOI POSSIVEL CONECTAR AO SERVIDOR TENTE MAIS TARDE");			 
		}			
		
	}
	
	
	public String logout() 
	{				
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login.faces?faces-redirect=true";
	}

	public String logar()	
	{
		//utilitario
		Util msg = new Util();
		try
		{				
			usuario = new Usuario();
			this.usuario.setEmail(this.getEmail());
			this.usuario.setSenha(this.getSenha());			
			this.setEmail("");
			this.setSenha("");
			
			usuario = usuario.autenticar();
			
			if(this.usuario.autenticar().getSenha().hashCode() == this.getSenha().hashCode()) 
			{				
				return "/usuario/eleicao?faces-redirect=true";
			}
			else 
			{
				msg.mensagemErro("E-mail e/ou senha  incorretos. Tente novamente");				 
			}			 
			
		} catch (Exception e) 
		{
			msg.mensagemSucesso("NÃO FOI POSSIVEL CONECTAR AO SERVIDOR TENTE MAIS TARDE");			 
		}
		
		return null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	


	
	

	
}
