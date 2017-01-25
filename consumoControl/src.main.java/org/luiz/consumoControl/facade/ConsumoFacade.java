/**
 * 
 */
package org.luiz.consumoControl.facade;

import org.luiz.consumoControl.dao.ConsumoDAO;
import org.luiz.consumoControl.facade.generic.GenericFacade;
import org.luiz.consumoControl.vo.Consumo;

/**
 * @author luizantonioalmeida
 *
 */
public class ConsumoFacade extends GenericFacade<Consumo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1592388971450585648L;
	private static ConsumoFacade service;
	private ConsumoDAO<Consumo> dao; 

	public static ConsumoFacade getInstance() {
		if (service == null){
			service = new ConsumoFacade();
		}
		return service;
	}

	@Override
	protected ConsumoDAO<Consumo> getDAO() {
		if (dao == null){
			dao = new ConsumoDAO<Consumo>(getEm());
		}
		
		return dao;
	}
	
	public Consumo findById(Long id) {
		Consumo result = getDAO().findById(id);
		return result;
	}
}
