/**
 * 
 */
package org.luiz.consumoControl.delegate;

/**
 * Classe que encapsula a lógica de implementação da Classe Unidade, bem como suas regras de negócio
 * @author luizantonioalmeida
 *
 */

import java.util.List;

import org.luiz.consumoControl.facade.UnidadeFacade;
import org.luiz.consumoControl.vo.Unidade;

public class UnidadeDelegate {

	private static UnidadeDelegate instancia;
	private static UnidadeFacade facade;
	
	/**
	 * Construtor privado da classe UnidadeDelegate para a implementação do Pattern Singleton
	 */
	private UnidadeDelegate(){
		super();
		
		if (facade == null){
			facade = UnidadeFacade.getInstance();
		}
	}
	
	public static UnidadeDelegate getInstance(){
		if (instancia == null) {
			instancia = new UnidadeDelegate();
		}
		
		return instancia;
	}

	public Boolean incluir(Unidade objeto) {
		return facade.incluir(objeto);
	}

	public Boolean alterar(Unidade objeto) {
		return facade.alterar(objeto);
	}

	public Boolean excluir(Unidade objeto) {
		return facade.excluir(objeto);
	}
	
	public List<Unidade> findAll(){
		return facade.findAll();
	}

	/**
	 * 
	 */
	public Unidade findById(Long id){
		return facade.findById(id);
	}
}
