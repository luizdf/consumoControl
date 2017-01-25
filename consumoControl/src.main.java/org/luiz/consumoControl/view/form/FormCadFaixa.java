package org.luiz.consumoControl.view.form;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.luiz.consumoControl.delegate.FaixaDelegate;
import org.luiz.consumoControl.view.page.FaixaPage;
import org.luiz.consumoControl.vo.Faixa;

/**
 * @author luizantonioalmeida
 *
 */
public class FormCadFaixa extends Form<Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Faixa faixa = new Faixa();
	
	public FormCadFaixa() {
		super("formCadFaixa");
		carregaCamposFormulario();
	}

	public FormCadFaixa(Faixa faixa) {
		super("formCadFaixa");
		this.faixa = faixa;
		carregaCamposFormulario();
	}

	@SuppressWarnings("rawtypes")
	private void carregaCamposFormulario() {
        PropertyModel<String> mdlNome = new PropertyModel<String>(this.faixa, "nome");
        PropertyModel<Double> mdlValorInicial = new PropertyModel<Double>(this.faixa, "valorInicial");
        PropertyModel<Double> mdlValorFinal = new PropertyModel<Double>(this.faixa, "valorFinal");
        
        TextField<String> campoNome = new TextField<String>("txtNome",mdlNome);
        TextField<Double> campoValorInicial = new TextField<Double>("txtValorInicial",mdlValorInicial);
        TextField<Double> campoValorFinal = new TextField<Double>("txtValorFinal",mdlValorFinal);
        
        add(campoNome);
        add(campoValorInicial);
        add(campoValorFinal);

        add(new Link("linkCancelar"){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
        		setResponsePage(FaixaPage.class);
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

		FaixaDelegate faixaDelegate = FaixaDelegate.getInstance();
		if (this.faixa.getId() > 0){
			faixaDelegate.alterar(faixa);
		} else{
			faixaDelegate.incluir(faixa);
		}
		setResponsePage(FaixaPage.class);		
	}
	
	protected void onReset(){
		
	}
}