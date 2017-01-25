/**
 * 
 */
package org.luiz.consumoControl.view.page;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.luiz.consumoControl.view.app.Sessao;
import org.luiz.consumoControl.vo.Usuario;

/**
 * @author luizantonioalmeida
 *
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class BasePage extends WebPage {

	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	
	public BasePage(){
		super();
		adicionaCampos();
	}
	
	private void adicionaCampos(){
		add(new BookmarkablePageLink("linkHome", Index.class));
		add(new BookmarkablePageLink("linkFaixaConsumo", FaixaPage.class));
		add(new BookmarkablePageLink("linkUnidadeMedida", UnidadeMedidaPage.class));
		
        PropertyModel<String> mdlNomeLogin = new PropertyModel<String>(getUsuario(), "nome");
        Label campoNomeLogin = new Label("nomeLogin",mdlNomeLogin);
        add(campoNomeLogin);

		Link linkSair = new Link("linkSair"){
	    	/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
	    	public void onClick() {
	    		Sessao.getInstancia(getRequest()).setAtributo("usuario",null);
	    		setResponsePage(LoginPage.class);
	    	}

			@Override
			public MarkupContainer setDefaultModel(IModel model) {
				return super.setDefaultModel(model);
			}
		};
	    linkSair.add(new AttributeModifier("onclick", "return confirm('Deseja Sair?');"));
	    add(linkSair);

		Link linkMeusDados = new Link("linkMeusDados"){
	    	/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
	    	public void onClick() {
	    		setResponsePage(UsuarioPage.class);
	    	}

			@Override
			public MarkupContainer setDefaultModel(IModel model) {
				return super.setDefaultModel(model);
			}
		};
	    add(linkMeusDados);        
	}

	public Usuario getUsuario() {
		if (usuario == null){
			usuario = (Usuario) Sessao.getInstancia(getRequest()).getAtributo("usuario");		
		}
		
		return usuario;
	}
}
