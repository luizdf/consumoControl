/**
 * 
 */
package org.luiz.consumoControl.facade;

import org.luiz.consumoControl.dao.EmpreendimentoDAO;
import org.luiz.consumoControl.facade.generic.GenericFacade;
import org.luiz.consumoControl.vo.Empreendimento;

/**
 * @author luizantonioalmeida
 *
 */
public class EmpreendimentoFacade extends GenericFacade<Empreendimento> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1592388971450585648L;
	private static EmpreendimentoFacade service;
	private EmpreendimentoDAO<Empreendimento> dao; 

	public static EmpreendimentoFacade getInstance() {
		if (service == null){
			service = new EmpreendimentoFacade();
		}
		return service;
	}

	@Override
	protected EmpreendimentoDAO<Empreendimento> getDAO() {
		if (dao == null){
			dao = new EmpreendimentoDAO<Empreendimento>(getEm());
		}
		
		return dao;
	}
	
	public Empreendimento findById(Long id) {
		Empreendimento result = getDAO().findById(id);
		return result;
	}
}
