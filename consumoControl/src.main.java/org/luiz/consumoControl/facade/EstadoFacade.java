/**
 * 
 */
package org.luiz.consumoControl.facade;

import org.luiz.consumoControl.dao.EstadoDAO;
import org.luiz.consumoControl.facade.generic.GenericFacade;
import org.luiz.consumoControl.vo.Estado;

/**
 * @author luizantonioalmeida
 *
 */
public class EstadoFacade extends GenericFacade<Estado> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1592388971450585648L;
	private static EstadoFacade service;
	private EstadoDAO<Estado> dao; 

	public static EstadoFacade getInstance() {
		if (service == null){
			service = new EstadoFacade();
		}
		return service;
	}

	@Override
	protected EstadoDAO<Estado> getDAO() {
		if (dao == null){
			dao = new EstadoDAO<Estado>(getEm());
		}
		
		return dao;
	}
	
	public Estado findById(Long id) {
		Estado result = getDAO().findById(id);
		return result;
	}

	public Estado findBySigla(String sigla) {
		Estado result = getDAO().findBySigla(sigla);
		return result;
	}
}
