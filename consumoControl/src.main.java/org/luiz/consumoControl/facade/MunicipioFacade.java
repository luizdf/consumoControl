/**
 * 
 */
package org.luiz.consumoControl.facade;

import org.luiz.consumoControl.dao.MunicipioDAO;
import org.luiz.consumoControl.facade.generic.GenericFacade;
import org.luiz.consumoControl.vo.Municipio;

/**
 * @author luizantonioalmeida
 *
 */
public class MunicipioFacade extends GenericFacade<Municipio> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1592388971450585648L;
	private static MunicipioFacade service;
	private MunicipioDAO<Municipio> dao; 

	public static MunicipioFacade getInstance() {
		if (service == null){
			service = new MunicipioFacade();
		}
		return service;
	}

	@Override
	protected MunicipioDAO<Municipio> getDAO() {
		if (dao == null){
			dao = new MunicipioDAO<Municipio>(getEm());
		}
		
		return dao;
	}
	
	public Municipio findById(Long id) {
		Municipio result = getDAO().findById(id);
		return result;
	}
}
