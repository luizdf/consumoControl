/**
 * 
 */
package org.luiz.consumoControl.delegate;

/**
 * Classe que encapsula a lógica de implementação da Classe TipoConsumo, bem como suas regras de negócio
 * @author luizantonioalmeida
 *
 */

import java.util.List;

import org.luiz.consumoControl.facade.TipoConsumoFacade;
import org.luiz.consumoControl.vo.TipoConsumo;

public class TipoConsumoDelegate {

	private static TipoConsumoDelegate instancia;
	private static TipoConsumoFacade facade;
	
	/**
	 * Construtor privado da classe TipoConsumoDelegate para a implementação do Pattern Singleton
	 */
	private TipoConsumoDelegate(){
		super();
		
		if (facade == null){
			facade = TipoConsumoFacade.getInstance();
		}
	}
	
	public static TipoConsumoDelegate getInstance(){
		if (instancia == null) {
			instancia = new TipoConsumoDelegate();
		}
		
		return instancia;
	}

	public Boolean incluir(TipoConsumo objeto) {
		return facade.incluir(objeto);
	}

	public Boolean alterar(TipoConsumo objeto) {
		return facade.alterar(objeto);
	}

	public Boolean excluir(TipoConsumo objeto) {
		return facade.excluir(objeto);
	}
	
	public List<TipoConsumo> findAll(){
		return facade.findAll();
	}

	/**
	 * 
	 */
	public TipoConsumo findById(Long id){
		return facade.findById(id);
	}
}
