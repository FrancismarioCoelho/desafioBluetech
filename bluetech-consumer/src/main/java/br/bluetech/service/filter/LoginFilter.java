package br.bluetech.service.filter;


import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bluetech.controller.UsuarioControle;



public class LoginFilter implements Filter 
{
	@Inject
	private UsuarioControle loginControle;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException 
	{	 
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException 
	{
		HttpServletRequest req =  (HttpServletRequest) request;
		HttpServletResponse res= (HttpServletResponse) response;
				
		String url =req.getRequestURI().toString();
		
		try {
			if(url.contains("/usuario") ) 				
			{
				
				if(loginControle.getUsuario().autenticar().getId() != null) 
				{
					chain.doFilter(request, response);
				}
				else 
				{
					 
					res.sendRedirect(req.getServletContext().getContextPath()+"/login.jsf");
				}
			}
			
			
			
			
		} catch (NullPointerException e) 
		{
			res.sendRedirect(req.getServletContext().getContextPath()+"/index.jsf");
		} 	
	}

	
	@Override
	public void destroy() 
	{
		 
	}

}
