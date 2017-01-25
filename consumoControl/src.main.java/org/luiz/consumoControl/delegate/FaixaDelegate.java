/**
 * 
 */
package org.luiz.consumoControl.delegate;

import java.util.List;

import org.luiz.consumoControl.facade.FaixaFacade;
import org.luiz.consumoControl.vo.Faixa;

/**
 * Classe que encapsula a lógica de implementação de Faixas, bem como suas regras de negócio
 * @author luizantonioalmeida
 *
 */
public class FaixaDelegate {

	private static FaixaDelegate instancia;
	private static FaixaFacade facade;
	
	/**
	 * Construtor privado da classe FaixaDelegate para a implementação do Pattern Singleton
	 */
	private FaixaDelegate(){
		super();
		
		if (facade == null){
			facade = FaixaFacade.getInstance();
		}
	}
	
	/**
	 * Método para instanciar o objeto FaixaDelegate para que seja utilizado pela aplicação utilizando o Pattern Singleton
	 * @return retorna uma instância de FaixaDelegate nova caso não exista, do contrário retorna a existente
	 */
	public static FaixaDelegate getInstance(){
		if (instancia == null) {
			instancia = new FaixaDelegate();
		}
		
		return instancia;
	}

	/**
	 * Método para incluir uma faixa no banco de dados
	 * @param objeto é o objeto a ser incluído no banco de dados
	 * @return retorna verdadeiro caso consiga incluir e falso caso contrário
	 */
	public Boolean incluir(Faixa objeto) {
		return facade.incluir(objeto);
	}

	/**
	 * Método para editar os dados de uma faixa no banco de dados
	 * @param objeto é o objeto a ser editado no banco de dados
	 * @return retorna verdadeiro caso consiga editar e falso caso contrário
	 */
	public Boolean alterar(Faixa objeto) {
		return facade.alterar(objeto);
	}

	/**
	 * Método para excluir uma faixa do banco de dados
	 * @param objeto é o objeto a ser excluido do banco de dados
	 * @return retorna verdadeiro caso consiga excluir e falso caso contrário
	 */
	public Boolean excluir(Faixa objeto) {
		return facade.excluir(objeto);
	}
	
	/**
	 * Método para buscar todas as faixas no banco de dados
	 * @return retorna a lista de faixas cadastradas no banco de dados, caso não exista nenhuma, retorna uma lista vazia
	 */
	public List<Faixa> findAll(){
		return facade.findAll();
	}
}
