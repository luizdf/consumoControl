/**
 * 
 */
package org.luiz.consumoControl.delegate;

/**
 * Classe que encapsula a lógica de implementação de Competencias, bem como suas regras de negócio
 * @author luizantonioalmeida
 *
 */

import java.util.List;

import org.luiz.consumoControl.facade.CompetenciaFacade;
import org.luiz.consumoControl.vo.Competencia;

public class CompetenciaDelegate {

	private static CompetenciaDelegate instancia;
	private static CompetenciaFacade facade;
	
	/**
	 * Construtor privado da classe CompetenciaDelegate para a implementação do Pattern Singleton
	 */
	private CompetenciaDelegate(){
		super();
		
		if (facade == null){
			facade = CompetenciaFacade.getInstance();
		}
	}
	
	/**
	 * Método para instanciar o objeto CompetenciaDelegate para que seja utilizado pela aplicação utilizando o Pattern Singleton
	 * @return retorna uma instância de CompetenciaDelegate nova caso não exista, do contrário retorna a existente
	 */
	public static CompetenciaDelegate getInstance(){
		if (instancia == null) {
			instancia = new CompetenciaDelegate();
		}
		
		return instancia;
	}

	/**
	 * Método para incluir uma Competencia no banco de dados
	 * @param objeto é o objeto a ser incluído no banco de dados
	 * @return retorna verdadeiro caso consiga incluir e falso caso contrário
	 */
	public Boolean incluir(Competencia objeto) {
		return facade.incluir(objeto);
	}

	/**
	 * Método para editar os dados de uma Competencia no banco de dados
	 * @param objeto é o objeto a ser editado no banco de dados
	 * @return retorna verdadeiro caso consiga editar e falso caso contrário
	 */
	public Boolean alterar(Competencia objeto) {
		return facade.alterar(objeto);
	}

	/**
	 * Método para excluir uma Competencia do banco de dados
	 * @param objeto é o objeto a ser excluido do banco de dados
	 * @return retorna verdadeiro caso consiga excluir e falso caso contrário
	 */
	public Boolean excluir(Competencia objeto) {
		return facade.excluir(objeto);
	}
	
	/**
	 * Método para buscar todas as Competencia no banco de dados
	 * @return retorna a lista de Competencias cadastradas no banco de dados, caso não exista nenhum, retorna uma lista vazia
	 */
	public List<Competencia> findAll(){
		return facade.findAll();
	}

	/**
	 * 
	 */
	public Competencia findById(Long id){
		return facade.findById(id);
	}
}
