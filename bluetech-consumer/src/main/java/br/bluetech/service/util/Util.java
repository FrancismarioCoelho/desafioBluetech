package br.bluetech.service.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Util 
{
	
	public void mensagemSucesso(String msg) 
	{
		try 
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(null, msg));
		} catch (Exception e) 
		{			
			e.printStackTrace();
		}
	}
	
	
	public void mensagemErro(String msg) 
	{
		try 
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atenção!!!", msg));
		} catch (Exception e) 
		{			
			e.printStackTrace();
		}
	}

}
