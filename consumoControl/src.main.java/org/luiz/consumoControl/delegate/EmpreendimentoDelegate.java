/**
 * 
 */
package org.luiz.consumoControl.delegate;

/**
 * Classe que encapsula a lógica de implementação da Classe Empreendimento, bem como suas regras de negócio
 * @author luizantonioalmeida
 *
 */

import java.util.List;

import org.luiz.consumoControl.facade.EmpreendimentoFacade;
import org.luiz.consumoControl.vo.Empreendimento;

public class EmpreendimentoDelegate {

	private static EmpreendimentoDelegate instancia;
	private static EmpreendimentoFacade facade;
	
	/**
	 * Construtor privado da classe EmpreendimentoDelegate para a implementação do Pattern Singleton
	 */
	private EmpreendimentoDelegate(){
		super();
		
		if (facade == null){
			facade = EmpreendimentoFacade.getInstance();
		}
	}
	
	public static EmpreendimentoDelegate getInstance(){
		if (instancia == null) {
			instancia = new EmpreendimentoDelegate();
		}
		
		return instancia;
	}

	public Boolean incluir(Empreendimento objeto) {
		return facade.incluir(objeto);
	}

	public Boolean alterar(Empreendimento objeto) {
		return facade.alterar(objeto);
	}

	public Boolean excluir(Empreendimento objeto) {
		return facade.excluir(objeto);
	}
	
	public List<Empreendimento> findAll(){
		return facade.findAll();
	}

	/**
	 * 
	 */
	public Empreendimento findById(Long id){
		return facade.findById(id);
	}
}
