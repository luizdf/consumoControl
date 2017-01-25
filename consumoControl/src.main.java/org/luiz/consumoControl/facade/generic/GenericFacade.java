package org.luiz.consumoControl.facade.generic;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import org.luiz.consumoControl.dao.generic.GenericDAO;
import org.luiz.consumoControl.factory.JpaFactory;

public abstract class GenericFacade<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static EntityManager em;

	/**
	 * @return the em
	 */
	public EntityManager getEm() {
		if (em == null){
			em = JpaFactory.getEntityManager();			
		}
		
		return em;
	}
	
	protected abstract GenericDAO<T> getDAO();
	
	public boolean incluir(T entidade) {
		boolean result = false;
		if (entidade != null){
			result = getDAO().incluir(entidade);
		}
		
		return result;
	}
	
	public boolean alterar(T entidade){
		boolean result = false;
		if (entidade != null){
			result = getDAO().alterar(entidade);
		}
		
		return result;
	}

	public boolean excluir(T entidade){
		boolean result = false;
		if (entidade != null){
			result = getDAO().excluir(entidade);
		}
		
		return result;
	}
	
	public boolean excluir(List<T> entidades) {
		boolean result = false;
		if (entidades != null){
			result = getDAO().excluir(entidades);
		}
		
		return result;
	}
	
	public List<T> findAll(){
		List<T> result = getDAO().findAll();

		return result;
	}
}
