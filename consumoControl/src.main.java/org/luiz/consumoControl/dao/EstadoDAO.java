/**
 * 
 */
package org.luiz.consumoControl.dao;

/**
 * @author luizantonioalmeida
 *
 */
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import org.luiz.consumoControl.dao.generic.GenericDAO;
import org.luiz.consumoControl.vo.Estado;

@SuppressWarnings({ "unchecked", "hiding" })
public class EstadoDAO<Estado> extends GenericDAO<Estado>{
	/**	
	 * @param em
	 */
	public EstadoDAO(EntityManager em) {
		super(em);
	}

	@Override
	public List<Estado> findAll() {
		List<Estado> result = new ArrayList<Estado>();
		EntityTransaction transacao = getEm().getTransaction();
		try {
			transacao.begin();
			result = (ArrayList<Estado>)getEm().createNamedQuery("Estado.findAll").getResultList();
			transacao.commit();
		} catch (Exception e) {
			transacao.rollback();
			e.printStackTrace();
		}
		return result;
	}

	public Estado findById(Long id) {
		Estado result = null;
		EntityTransaction transacao = getEm().getTransaction();
		try {
			Query query;

			query = getEm().createNamedQuery("Estado.findById");
			query.setParameter("id", id);

			transacao.begin();
			result = (Estado)query.getSingleResult();
			transacao.commit();

			return result;
		} catch (NoResultException e) {
			transacao.rollback();
			System.out.println("Não foi localizado o Estado de ID: " + id);
			return null;
		} catch (Exception e) {
			transacao.rollback();
			e.printStackTrace();
			return null;
		}
	}

	public Estado findBySigla(String sigla) {
		Estado result = null;
		EntityTransaction transacao = getEm().getTransaction();
		try {
			Query query;

			query = getEm().createNamedQuery("Estado.findBySigla");
			query.setParameter("sigla", sigla);

			transacao.begin();
			result = (Estado)query.getSingleResult();
			transacao.commit();

			return result;
		} catch (NoResultException e) {
			transacao.rollback();
			System.out.println("Não foi localizado o Estado de Sigla: " + sigla);
			return null;
		} catch (Exception e) {
			transacao.rollback();
			e.printStackTrace();
			return null;
		}
	}
}
