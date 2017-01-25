/**
 * 
 */
package org.luiz.consumoControl.delegate;

/**
 * Classe que encapsula a lógica de implementação da Classe Pessoa, bem como suas regras de negócio
 * @author luizantonioalmeida
 *
 */

import java.util.List;

import org.luiz.consumoControl.facade.PessoaFacade;
import org.luiz.consumoControl.vo.Pessoa;

public class PessoaDelegate {

	private static PessoaDelegate instancia;
	private static PessoaFacade facade;
	
	/**
	 * Construtor privado da classe PessoaDelegate para a implementação do Pattern Singleton
	 */
	private PessoaDelegate(){
		super();
		
		if (facade == null){
			facade = PessoaFacade.getInstance();
		}
	}
	
	public static PessoaDelegate getInstance(){
		if (instancia == null) {
			instancia = new PessoaDelegate();
		}
		
		return instancia;
	}

	public Boolean incluir(Pessoa objeto) {
		return facade.incluir(objeto);
	}

	public Boolean alterar(Pessoa objeto) {
		return facade.alterar(objeto);
	}

	public Boolean excluir(Pessoa objeto) {
		return facade.excluir(objeto);
	}
	
	public List<Pessoa> findAll(){
		return facade.findAll();
	}

	/**
	 * 
	 */
	public Pessoa findById(Long id){
		return facade.findById(id);
	}
}
