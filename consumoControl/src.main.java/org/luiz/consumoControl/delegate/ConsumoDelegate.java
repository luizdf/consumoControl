/**
 * 
 */
package org.luiz.consumoControl.delegate;

/**
 * Classe que encapsula a lógica de implementação de Consumos, bem como suas regras de negócio
 * @author luizantonioalmeida
 *
 */

import java.util.List;

import org.luiz.consumoControl.facade.ConsumoFacade;
import org.luiz.consumoControl.vo.Consumo;

/**
 * Classe que encapsula a lógica de implementação de Consumos, bem como suas regras de negócio
 * @author luizantonioalmeida
 *
 */
public class ConsumoDelegate {

	private static ConsumoDelegate instancia;
	private static ConsumoFacade facade;
	
	/**
	 * Construtor privado da classe ConsumoDelegate para a implementação do Pattern Singleton
	 */
	private ConsumoDelegate(){
		super();
		
		if (facade == null){
			facade = ConsumoFacade.getInstance();
		}
	}
	
	/**
	 * Método para instanciar o objeto ConsumoDelegate para que seja utilizado pela aplicação utilizando o Pattern Singleton
	 * @return retorna uma instância de ConsumoDelegate nova caso não exista, do contrário retorna a existente
	 */
	public static ConsumoDelegate getInstance(){
		if (instancia == null) {
			instancia = new ConsumoDelegate();
		}
		
		return instancia;
	}

	/**
	 * Método para incluir um Consumo no banco de dados
	 * @param objeto é o objeto a ser incluído no banco de dados
	 * @return retorna verdadeiro caso consiga incluir e falso caso contrário
	 */
	public Boolean incluir(Consumo objeto) {
		return facade.incluir(objeto);
	}

	/**
	 * Método para editar os dados de um Consumo no banco de dados
	 * @param objeto é o objeto a ser editado no banco de dados
	 * @return retorna verdadeiro caso consiga editar e falso caso contrário
	 */
	public Boolean alterar(Consumo objeto) {
		return facade.alterar(objeto);
	}

	/**
	 * Método para excluir um Consumo do banco de dados
	 * @param objeto é o objeto a ser excluido do banco de dados
	 * @return retorna verdadeiro caso consiga excluir e falso caso contrário
	 */
	public Boolean excluir(Consumo objeto) {
		return facade.excluir(objeto);
	}
	
	/**
	 * Método para buscar todas os Consumos no banco de dados
	 * @return retorna a lista de Consumos cadastrados no banco de dados, caso não exista nenhum, retorna uma lista vazia
	 */
	public List<Consumo> findAll(){
		return facade.findAll();
	}

	/**
	 * 
	 */
	public Consumo findById(Long id){
		return facade.findById(id);
	}
}