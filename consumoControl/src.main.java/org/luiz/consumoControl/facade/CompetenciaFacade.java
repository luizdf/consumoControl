/**
 * 
 */
package org.luiz.consumoControl.facade;

import org.luiz.consumoControl.dao.CompetenciaDAO;
import org.luiz.consumoControl.facade.generic.GenericFacade;
import org.luiz.consumoControl.vo.Competencia;

/**
 * @author luizantonioalmeida
 *
 */
public class CompetenciaFacade extends GenericFacade<Competencia> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1592388971450585648L;
	private static CompetenciaFacade service;
	private CompetenciaDAO<Competencia> dao; 

	public static CompetenciaFacade getInstance() {
		if (service == null){
			service = new CompetenciaFacade();
		}
		return service;
	}

	@Override
	protected CompetenciaDAO<Competencia> getDAO() {
		if (dao == null){
			dao = new CompetenciaDAO<Competencia>(getEm());
		}
		
		return dao;
	}
	
	public Competencia findById(Long id) {
		Competencia result = getDAO().findById(id);
		return result;
	}
}
