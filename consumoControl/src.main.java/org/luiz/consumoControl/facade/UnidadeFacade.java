/**
 * 
 */
package org.luiz.consumoControl.facade;

import org.luiz.consumoControl.dao.UnidadeDAO;
import org.luiz.consumoControl.facade.generic.GenericFacade;
import org.luiz.consumoControl.vo.Unidade;

/**
 * @author luizantonioalmeida
 *
 */
public class UnidadeFacade extends GenericFacade<Unidade> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1592388971450585648L;
	private static UnidadeFacade service;
	private UnidadeDAO<Unidade> dao; 

	public static UnidadeFacade getInstance() {
		if (service == null){
			service = new UnidadeFacade();
		}
		return service;
	}

	@Override
	protected UnidadeDAO<Unidade> getDAO() {
		if (dao == null){
			dao = new UnidadeDAO<Unidade>(getEm());
		}
		
		return dao;
	}
	
	public Unidade findById(Long id) {
		Unidade result = getDAO().findById(id);
		return result;
	}
}
