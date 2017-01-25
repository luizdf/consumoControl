/**
 * 
 */
package org.luiz.consumoControl.facade;

import org.luiz.consumoControl.dao.UsuarioDAO;
import org.luiz.consumoControl.facade.generic.GenericFacade;
import org.luiz.consumoControl.vo.Usuario;

/**
 * @author luizantonioalmeida
 *
 */
public class UsuarioFacade extends GenericFacade<Usuario> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1592388971450585648L;
	private static UsuarioFacade service;
	private UsuarioDAO<Usuario> dao; 

	public static UsuarioFacade getInstance() {
		if (service == null){
			service = new UsuarioFacade();
		}
		return service;
	}

	@Override
	protected UsuarioDAO<Usuario> getDAO() {
		if (dao == null){
			dao = new UsuarioDAO<Usuario>(getEm());
		}
		
		return dao;
	}
	
	public Usuario findById(Long id) {
		Usuario result = getDAO().findById(id);
		return result;
	}

	public Usuario findByLogin(String login) {
		Usuario result = getDAO().findByLogin(login);
		return result;
	}
}
