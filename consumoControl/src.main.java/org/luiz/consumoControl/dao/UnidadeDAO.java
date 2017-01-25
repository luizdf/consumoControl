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
import org.luiz.consumoControl.vo.Unidade;

@SuppressWarnings({ "unchecked", "hiding" })
public class UnidadeDAO<Unidade> extends GenericDAO<Unidade>{
	/**	
	 * @param em
	 */
	public UnidadeDAO(EntityManager em) {
		super(em);
	}

	@Override
	public List<Unidade> findAll() {
		List<Unidade> result = new ArrayList<Unidade>();
		EntityTransaction transacao = getEm().getTransaction();
		try {
			transacao.begin();
			result = (ArrayList<Unidade>)getEm().createNamedQuery("Unidade.findAll").getResultList();
			transacao.commit();
		} catch (Exception e) {
			transacao.rollback();
			e.printStackTrace();
		}
		return result;
	}

	public Unidade findById(Long id) {
		Unidade result = null;
		EntityTransaction transacao = getEm().getTransaction();
		try {
			Query query;

			query = getEm().createNamedQuery("Unidade.findById");
			query.setParameter("id", id);

			transacao.begin();
			result = (Unidade)query.getSingleResult();
			transacao.commit();

			return result;
		} catch (NoResultException e) {
			transacao.rollback();
			System.out.println("Não foi localizada Unidade de ID: " + id);
			return null;
		} catch (Exception e) {
			transacao.rollback();
			e.printStackTrace();
			return null;
		}
	}
}
