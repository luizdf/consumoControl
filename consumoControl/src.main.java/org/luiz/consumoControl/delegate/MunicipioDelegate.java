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

import org.luiz.consumoControl.facade.MunicipioFacade;
import org.luiz.consumoControl.vo.Municipio;

/**
 * Classe que encapsula a lógica de implementação de Municipios, bem como suas regras de negócio
 * @author luizantonioalmeida
 *
 */
public class MunicipioDelegate {

	private static MunicipioDelegate instancia;
	private static MunicipioFacade facade;
	
	/**
	 * Construtor privado da classe MunicipioDelegate para a implementação do Pattern Singleton
	 */
	private MunicipioDelegate(){
		super();
		
		if (facade == null){
			facade = MunicipioFacade.getInstance();
		}
	}
	
	/**
	 * Método para instanciar o objeto MunicipioDelegate para que seja utilizado pela aplicação utilizando o Pattern Singleton
	 * @return retorna uma instância de MunicipioDelegate nova caso não exista, do contrário retorna a existente
	 */
	public static MunicipioDelegate getInstance(){
		if (instancia == null) {
			instancia = new MunicipioDelegate();
		}
		
		return instancia;
	}

	/**
	 * Método para incluir um Municipio no banco de dados
	 * @param objeto é o objeto a ser incluído no banco de dados
	 * @return retorna verdadeiro caso consiga incluir e falso caso contrário
	 */
	public Boolean incluir(Municipio objeto) {
		return facade.incluir(objeto);
	}

	/**
	 * Método para editar os dados de um Municipio no banco de dados
	 * @param objeto é o objeto a ser editado no banco de dados
	 * @return retorna verdadeiro caso consiga editar e falso caso contrário
	 */
	public Boolean alterar(Municipio objeto) {
		return facade.alterar(objeto);
	}

	/**
	 * Método para excluir um Municipio do banco de dados
	 * @param objeto é o objeto a ser excluido do banco de dados
	 * @return retorna verdadeiro caso consiga excluir e falso caso contrário
	 */
	public Boolean excluir(Municipio objeto) {
		return facade.excluir(objeto);
	}
	
	/**
	 * Método para buscar todos os Municipios no banco de dados
	 * @return retorna a lista de Municipios cadastrados no banco de dados, caso não exista nenhum, retorna uma lista vazia
	 */
	public List<Municipio> findAll(){
		return facade.findAll();
	}
	
	/**
	 * 
	 */
	public Municipio findById(Long id){
		return facade.findById(id);
	}
}