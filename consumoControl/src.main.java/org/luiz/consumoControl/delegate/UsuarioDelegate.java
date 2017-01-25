/**
 * 
 */
package org.luiz.consumoControl.delegate;

import java.util.List;

import org.luiz.consumoControl.facade.UsuarioFacade;
import org.luiz.consumoControl.vo.Usuario;

/**
 * Classe que encapsula a lógica de implementação de Usuários, bem como suas regras de negócio
 * @author luizantonioalmeida
 *
 */
public class UsuarioDelegate {

	private static UsuarioDelegate instancia;
	private static UsuarioFacade facade;
	
	/**
	 * Construtor privado da classe UsuarioDelegate para a implementação do Pattern Singleton
	 */
	private UsuarioDelegate(){
		super();
		
		if (facade == null){
			facade = UsuarioFacade.getInstance();
		}
	}
	
	/**
	 * Método para instanciar o objeto UsuarioDelegate para que seja utilizado pela aplicação utilizando o Pattern Singleton
	 * @return retorna uma instância de UsuarioDelegate nova caso não exista, do contrário retorna a existente
	 */
	public static UsuarioDelegate getInstance(){
		if (instancia == null) {
			instancia = new UsuarioDelegate();
		}
		
		return instancia;
	}

	/**
	 * Método para incluir um usuario no banco de dados
	 * @param usuario é o objeto a ser incluído no banco de dados
	 * @return retorna verdadeiro caso consiga incluir e falso caso contrário
	 */
	public Boolean incluir(Usuario usuario) {
		return facade.incluir(usuario);
	}

	/**
	 * Método para editar os dados de um usuario no banco de dados
	 * @param usuario é o objeto a ser editado no banco de dados
	 * @return retorna verdadeiro caso consiga editar e falso caso contrário
	 */
	public Boolean alterar(Usuario usuario) {
		return facade.alterar(usuario);
	}

	/**
	 * Método para excluir um usuario do banco de dados
	 * @param usuario é o objeto a ser excluido do banco de dados
	 * @return retorna verdadeiro caso consiga excluir e falso caso contrário
	 */
	public Boolean excluir(Usuario usuario) {
		return facade.excluir(usuario);
	}
	
	/**
	 * Método para buscar todos os arquivos no banco de dados
	 * @return retorna a lista de arquivos cadastrados no banco de dados, caso não exista nenhum, retorna uma lista vazia
	 */
	public List<Usuario> findAll(){
		return facade.findAll();
	}

	/**
	 * Método para buscar um objeto Usuario no banco de dados através do Login
	 * @param login Nome de Login do Usuário
	 * @return retorna um objeto usuario carregado caso o mesmo exista, do contrário retorna Null
	 */
	public Usuario findByLogin(String login) {
		return facade.findByLogin(login);
	}
}
