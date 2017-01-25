package org.luiz.consumoControl.dao.generic;

import java.util.List;
import javax.persistence.*;

/**
 * @author Luiz Ant�nio
 *
 */
public abstract class GenericDAO<T extends Object> implements IDAO<T> {
	/**
	 * 
	 */
	private EntityManager em;
	
	/**
	 * @param em
	 */
	public GenericDAO(EntityManager em){
		this.setEm(em);
	}

	@Override
	public boolean incluir(T entidade){
		boolean result = false;
		EntityTransaction transacao = getEm().getTransaction();
    	try {
			transacao.begin();
			getEm().persist(entidade);
			transacao.commit();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}
		return result;
	}

	@Override
	public boolean alterar(T entidade){
		boolean result = false;
		EntityTransaction transacao = getEm().getTransaction();
    	try {
			transacao.begin();
			getEm().merge(entidade);
			transacao.commit();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}
		return result;
	}
	
	@Override
	public boolean excluir(T entidade){
		boolean result = false;
		EntityTransaction transacao = getEm().getTransaction();
    	try {
			transacao.begin();
			getEm().merge(entidade);
			getEm().remove(entidade);
			transacao.commit();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}
		return result;
	}
	
	@Override
	public boolean excluir(List<T> entidades) {
		boolean result = false;
		EntityTransaction transacao = getEm().getTransaction();
    	try {
			transacao.begin();
			for (T entidade : entidades) {
				getEm().merge(entidade);
				getEm().remove(entidade);
			}
			transacao.commit();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}
		return result;
	}

	/**
	 * @param em the em to set
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}

	/**
	 * @return the em
	 */
	public EntityManager getEm() {
		return em;
	}

	public abstract List<T> findAll();
}