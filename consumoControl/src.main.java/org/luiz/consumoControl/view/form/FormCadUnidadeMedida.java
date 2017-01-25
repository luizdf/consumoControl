package org.luiz.consumoControl.view.form;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.luiz.consumoControl.delegate.UnidadeMedidaDelegate;
import org.luiz.consumoControl.view.page.UnidadeMedidaPage;
import org.luiz.consumoControl.vo.UnidadeMedida;

/**
 * @author luizantonioalmeida
 *
 */
public class FormCadUnidadeMedida extends Form<Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UnidadeMedida unidadeMedida = new UnidadeMedida();
	
	public FormCadUnidadeMedida() {
		super("formCadUnidadeMedida");
		carregaCamposFormulario();
	}

	public FormCadUnidadeMedida(UnidadeMedida unidadeMedida) {
		super("formCadUnidadeMedida");
		this.unidadeMedida = unidadeMedida;
		carregaCamposFormulario();
	}

	@SuppressWarnings("rawtypes")
	private void carregaCamposFormulario() {
        PropertyModel<String> mdlNome = new PropertyModel<String>(this.unidadeMedida, "nome");
        
        TextField<String> campoNome = new TextField<String>("txtNome",mdlNome);
        
        add(campoNome);

        add(new Link("linkCancelar"){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
        		setResponsePage(UnidadeMedidaPage.class);
			}
			
			@Override
			public MarkupContainer setDefaultModel(IModel model) {
				return super.setDefaultModel(model);
			}
        });
	}

	@Override
	protected void onSubmit() {
		super.onSubmit();

		UnidadeMedidaDelegate unidadeMedidaDelegate = UnidadeMedidaDelegate.getInstance();
		if (this.unidadeMedida.getId() > 0){
			unidadeMedidaDelegate.alterar(unidadeMedida);
		} else{
			unidadeMedidaDelegate.incluir(unidadeMedida);
		}
		setResponsePage(UnidadeMedidaPage.class);		
	}
}