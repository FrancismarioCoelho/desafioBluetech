package br.com.bluetech.model;

 
 
import java.util.List;

 

import com.owlike.genson.annotation.JsonIgnore;

import br.bluetech.service.UsuarioService;


public class Usuario 
{
	

	
	private Long id;
	private String nome;
	private String email;
	private String senha;
	@JsonIgnore
	public boolean status; // quando true usuario já votou
	
	
	
	public Usuario inserir() 
	{
		UsuarioService usuarioService = new UsuarioService();
		this.setId(0L);		
		return usuarioService.inserir(this);
	}
	
	public boolean verificarEmail() 
	{
		for (Usuario u : this.lista()) 
		{
			if(this.getEmail().hashCode() == u.getEmail().hashCode()) 
			{
				return true;
			}
		}
		return false;
	}
	
	//faz o login da aplicacao
	public Usuario autenticar() 
	{
		UsuarioService service = new UsuarioService();		
		return service.buscaUsuario(this);
	}
	
	public List<Usuario> lista()
	{
		return new UsuarioService().listar(); 
	}
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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

	public boolean isStatus() 
	{
		Eleicao eleicao = new Eleicao();
		for (Eleicao e : eleicao.listar())
		{
			if(this.getId().hashCode() == e.getUsuario_id().hashCode() ) 
			{
				status = true;
			}
			else 
			{
				status = false; 
			}
		}
		
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	
	
	 
	

}
