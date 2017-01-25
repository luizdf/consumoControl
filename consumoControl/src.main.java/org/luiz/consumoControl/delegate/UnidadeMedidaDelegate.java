/**
 * 
 */
package org.luiz.consumoControl.delegate;

/**
 * Classe que encapsula a lógica de implementação da Classe UnidadeMedida, bem como suas regras de negócio
 * @author luizantonioalmeida
 *
 */

import java.util.List;

import org.luiz.consumoControl.facade.UnidadeMedidaFacade;
import org.luiz.consumoControl.vo.UnidadeMedida;

public class UnidadeMedidaDelegate {

	private static UnidadeMedidaDelegate instancia;
	private static UnidadeMedidaFacade facade;
	
	/**
	 * Construtor privado da classe UnidadeMedidaDelegate para a implementação do Pattern Singleton
	 */
	private UnidadeMedidaDelegate(){
		super();
		
		if (facade == null){
			facade = UnidadeMedidaFacade.getInstance();
		}
	}
	
	public static UnidadeMedidaDelegate getInstance(){
		if (instancia == null) {
			instancia = new UnidadeMedidaDelegate();
		}
		
		return instancia;
	}

	public Boolean incluir(UnidadeMedida objeto) {
		return facade.incluir(objeto);
	}

	public Boolean alterar(UnidadeMedida objeto) {
		return facade.alterar(objeto);
	}

	public Boolean excluir(UnidadeMedida objeto) {
		return facade.excluir(objeto);
	}
	
	public List<UnidadeMedida> findAll(){
		return facade.findAll();
	}

	/**
	 * 
	 */
	public UnidadeMedida findById(Long id){
		return facade.findById(id);
	}
}
