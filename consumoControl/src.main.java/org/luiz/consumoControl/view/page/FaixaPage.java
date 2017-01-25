/**
 * 
 */
package org.luiz.consumoControl.view.page;

import java.util.List;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.model.IModel;
import org.luiz.consumoControl.delegate.FaixaDelegate;
import org.luiz.consumoControl.view.form.FormCadFaixa;
import org.luiz.consumoControl.vo.Faixa;

/**
 * @author luizantonioalmeida
 *
 */
public class FaixaPage extends BasePage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FormCadFaixa formCadFaixa;

	public FaixaPage(){
		super();
		formCadFaixa = new FormCadFaixa();
		formCadFaixa.setVisible(false);
		add(formCadFaixa);
		adicionaCampos();
	}

	public FaixaPage(Faixa faixa){
		super();
		formCadFaixa = new FormCadFaixa(faixa);
		add(formCadFaixa);
		adicionaCampos();
    }

	@SuppressWarnings("rawtypes")
	private void adicionaCampos(){
		final int itensPage = 7;
        List<Faixa> list = FaixaDelegate.getInstance().findAll();
          
        @SuppressWarnings({ "unchecked" })
		final DataView dataView = new DataView("rowTblFaixa", new ListDataProvider(list)) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@SuppressWarnings("serial")
			@Override
			protected void populateItem(final Item item) {
                final Faixa objeto = (Faixa) item.getModelObject();
                
                item.add(new Label("colID", objeto.getId()));
                item.add(new Label("colNome", objeto.getNome()));
                item.add(new Label("colValorInicial", objeto.getValorInicial()));
                item.add(new Label("colValorFinal", objeto.getValorFinal()));
                item.add(new Link("linkAlterar") {

					@Override
					public void onClick() {
		        		Faixa faixa = (Faixa)item.getModelObject();
		        		setResponsePage(new FaixaPage(faixa));
					}

					@Override
					public MarkupContainer setDefaultModel(IModel model) {
						return super.setDefaultModel(model);
					}
                });
                
                Link linkExcluir = new Link("linkExcluir") {

        	        /**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
		        		Faixa faixa = (Faixa)item.getModelObject();
		        		FaixaDelegate.getInstance().excluir(faixa);
		        		setResponsePage(FaixaPage.class);
					}

					@Override
					public MarkupContainer setDefaultModel(IModel model) {
						return super.setDefaultModel(model);
					}
                };
                
    	        linkExcluir.add(new AttributeModifier("onclick", "return confirm('Excluir Registro?');"));
                item.add(linkExcluir);
			}
        };

        dataView.setItemsPerPage(itensPage);
        
        add(dataView);
        add(new PagingNavigator("navTblFaixa", dataView).setVisible(list.size() > itensPage));
        
        Link linkNovoRegistro = new Link("linkNovoRegistro"){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
        		Faixa faixa = new Faixa();
        		setResponsePage(new FaixaPage(faixa));
			}

			@Override
			public MarkupContainer setDefaultModel(IModel model) {
				return super.setDefaultModel(model);
			}
        };
        
        linkNovoRegistro.setVisible(!formCadFaixa.isVisible());
        add(linkNovoRegistro);
	}
}