/**
 * 
 */
package org.luiz.consumoControl.delegate;

/**
 * Classe que encapsula a lógica de implementação de Estados, bem como suas regras de negócio
 * @author luizantonioalmeida
 *
 */

import java.util.List;

import org.luiz.consumoControl.facade.EstadoFacade;
import org.luiz.consumoControl.vo.Estado;

/**
 * Classe que encapsula a lógica de implementação de Estados, bem como suas regras de negócio
 * @author luizantonioalmeida
 *
 */
public class EstadoDelegate {

	private static EstadoDelegate instancia;
	private static EstadoFacade facade;
	
	/**
	 * Construtor privado da classe EstadoDelegate para a implementação do Pattern Singleton
	 */
	private EstadoDelegate(){
		super();
		
		if (facade == null){
			facade = EstadoFacade.getInstance();
		}
	}
	
	/**
	 * Método para instanciar o objeto EstadoDelegate para que seja utilizado pela aplicação utilizando o Pattern Singleton
	 * @return retorna uma instância de EstadoDelegate nova caso não exista, do contrário retorna a existente
	 */
	public static EstadoDelegate getInstance(){
		if (instancia == null) {
			instancia = new EstadoDelegate();
		}
		
		return instancia;
	}

	/**
	 * Método para incluir um estado no banco de dados
	 * @param objeto é o objeto a ser incluído no banco de dados
	 * @return retorna verdadeiro caso consiga incluir e falso caso contrário
	 */
	public Boolean incluir(Estado objeto) {
		return facade.incluir(objeto);
	}

	/**
	 * Método para editar os dados de um estado no banco de dados
	 * @param objeto é o objeto a ser editado no banco de dados
	 * @return retorna verdadeiro caso consiga editar e falso caso contrário
	 */
	public Boolean alterar(Estado objeto) {
		return facade.alterar(objeto);
	}

	/**
	 * Método para excluir um estado do banco de dados
	 * @param objeto é o objeto a ser excluido do banco de dados
	 * @return retorna verdadeiro caso consiga excluir e falso caso contrário
	 */
	public Boolean excluir(Estado objeto) {
		return facade.excluir(objeto);
	}
	
	/**
	 * Método para buscar todos os estados no banco de dados
	 * @return retorna a lista de estados cadastrados no banco de dados, caso não exista nenhum, retorna uma lista vazia
	 */
	public List<Estado> findAll(){
		return facade.findAll();
	}

	/**
	 * 
	 */
	public Estado findById(Long id){
		return facade.findById(id);
	}

	/**
	 * 
	 */
	public Estado findBySigla(String sigla) {
		return facade.findBySigla(sigla);
	}
}