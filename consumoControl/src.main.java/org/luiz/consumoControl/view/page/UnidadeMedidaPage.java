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
import org.luiz.consumoControl.delegate.UnidadeMedidaDelegate;
import org.luiz.consumoControl.view.form.FormCadUnidadeMedida;
import org.luiz.consumoControl.vo.UnidadeMedida;

/**
 * @author luizantonioalmeida
 *
 */
public class UnidadeMedidaPage extends BasePage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FormCadUnidadeMedida formCadUnidadeMedida;

	public UnidadeMedidaPage(){
		super();
		formCadUnidadeMedida = new FormCadUnidadeMedida();
		formCadUnidadeMedida.setVisible(false);
		add(formCadUnidadeMedida);
		adicionaCampos();
	}

	public UnidadeMedidaPage(UnidadeMedida unidadeMedida){
		super();
		formCadUnidadeMedida = new FormCadUnidadeMedida(unidadeMedida);
		add(formCadUnidadeMedida);
		adicionaCampos();
    }

	@SuppressWarnings("rawtypes")
	private void adicionaCampos(){
		final int itensPage = 7;
        List<UnidadeMedida> list = UnidadeMedidaDelegate.getInstance().findAll();
          
        @SuppressWarnings({ "unchecked" })
		final DataView dataView = new DataView("rowTblUnidadeMedida", new ListDataProvider(list)) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@SuppressWarnings("serial")
			@Override
			protected void populateItem(final Item item) {
                final UnidadeMedida objeto = (UnidadeMedida) item.getModelObject();
                
                item.add(new Label("colID", objeto.getId()));
                item.add(new Label("colNome", objeto.getNome()));
                item.add(new Link("linkAlterar") {

					@Override
					public void onClick() {
						UnidadeMedida unidadeMedida = (UnidadeMedida)item.getModelObject();
		        		setResponsePage(new UnidadeMedidaPage(unidadeMedida));
					}
					
					@Override
					public MarkupContainer setDefaultModel(IModel model) {
						return super.setDefaultModel(model);
					}
				});
                
                Link linkExcluir = new Link("linkExcluir") {

        	        @Override
					public void onClick() {
        	        	UnidadeMedida unidadeMedida = (UnidadeMedida)item.getModelObject();
        	        	UnidadeMedidaDelegate.getInstance().excluir(unidadeMedida);
		        		setResponsePage(UnidadeMedidaPage.class);
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
        add(new PagingNavigator("navTblUnidadeMedida", dataView).setVisible(list.size() > itensPage));
        
        Link linkNovoRegistro = new Link("linkNovoRegistro"){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				UnidadeMedida unidadeMedida = new UnidadeMedida();
        		setResponsePage(new UnidadeMedidaPage(unidadeMedida));
			}

			@Override
			public MarkupContainer setDefaultModel(IModel model) {
				return super.setDefaultModel(model);
			}
        };
        
        linkNovoRegistro.setVisible(!formCadUnidadeMedida.isVisible());
        add(linkNovoRegistro);
	}
}