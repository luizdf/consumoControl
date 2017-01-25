/**
 * 
 */
package org.luiz.consumoControl.delegate;

/**
 * Classe que encapsula a lógica de implementação da Classe Tarifa, bem como suas regras de negócio
 * @author luizantonioalmeida
 *
 */

import java.util.List;

import org.luiz.consumoControl.facade.TarifaFacade;
import org.luiz.consumoControl.vo.Tarifa;

public class TarifaDelegate {

	private static TarifaDelegate instancia;
	private static TarifaFacade facade;
	
	/**
	 * Construtor privado da classe TarifaDelegate para a implementação do Pattern Singleton
	 */
	private TarifaDelegate(){
		super();
		
		if (facade == null){
			facade = TarifaFacade.getInstance();
		}
	}
	
	public static TarifaDelegate getInstance(){
		if (instancia == null) {
			instancia = new TarifaDelegate();
		}
		
		return instancia;
	}

	public Boolean incluir(Tarifa objeto) {
		return facade.incluir(objeto);
	}

	public Boolean alterar(Tarifa objeto) {
		return facade.alterar(objeto);
	}

	public Boolean excluir(Tarifa objeto) {
		return facade.excluir(objeto);
	}
	
	public List<Tarifa> findAll(){
		return facade.findAll();
	}

	/**
	 * 
	 */
	public Tarifa findById(Long id){
		return facade.findById(id);
	}
}
