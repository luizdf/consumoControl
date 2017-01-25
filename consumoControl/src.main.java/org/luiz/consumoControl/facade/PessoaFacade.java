/**
 * 
 */
package org.luiz.consumoControl.facade;

import org.luiz.consumoControl.dao.PessoaDAO;
import org.luiz.consumoControl.facade.generic.GenericFacade;
import org.luiz.consumoControl.vo.Pessoa;

/**
 * @author luizantonioalmeida
 *
 */
public class PessoaFacade extends GenericFacade<Pessoa> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1592388971450585648L;
	private static PessoaFacade service;
	private PessoaDAO<Pessoa> dao; 

	public static PessoaFacade getInstance() {
		if (service == null){
			service = new PessoaFacade();
		}
		return service;
	}

	@Override
	protected PessoaDAO<Pessoa> getDAO() {
		if (dao == null){
			dao = new PessoaDAO<Pessoa>(getEm());
		}
		
		return dao;
	}
	
	public Pessoa findById(Long id) {
		Pessoa result = getDAO().findById(id);
		return result;
	}
}
