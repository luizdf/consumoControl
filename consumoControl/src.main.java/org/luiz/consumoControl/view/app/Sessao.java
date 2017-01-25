package org.luiz.consumoControl.view.app;

import org.apache.wicket.request.Request;
import java.io.Serializable;
import org.apache.wicket.protocol.http.WebSession;

public class Sessao extends WebSession {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Sessao instancia;

	public static Sessao getInstancia(Request request){
		
		if (instancia == null){
			instancia = new Sessao(request);
		}
		
		return instancia;
	}
	
	private Sessao(Request request) {
		super(request);
	}

	public Object getAtributo(String chave) {
		 return (Object)getAttribute(chave);
	}

	public void setAtributo(String chave, Object valor) {
		super.setAttribute(chave, (Serializable) valor);
	}
	
	public void removeAtributo(String chave){
		super.removeAttribute(chave);
	}
}
