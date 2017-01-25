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
import org.luiz.consumoControl.vo.Competencia;

@SuppressWarnings({ "unchecked", "hiding" })
public class CompetenciaDAO<Competencia> extends GenericDAO<Competencia>{
	/**	
	 * @param em
	 */
	public CompetenciaDAO(EntityManager em) {
		super(em);
	}

	@Override
	public List<Competencia> findAll() {
		List<Competencia> result = new ArrayList<Competencia>();
		EntityTransaction transacao = getEm().getTransaction();
		try {
			transacao.begin();
			result = (ArrayList<Competencia>)getEm().createNamedQuery("Competencia.findAll").getResultList();
			transacao.commit();
		} catch (Exception e) {
			transacao.rollback();
			e.printStackTrace();
		}
		return result;
	}

	public Competencia findById(Long id) {
		Competencia result = null;
		EntityTransaction transacao = getEm().getTransaction();
		try {
			Query query;

			query = getEm().createNamedQuery("Competencia.findById");
			query.setParameter("id", id);

			transacao.begin();
			result = (Competencia)query.getSingleResult();
			transacao.commit();

			return result;
		} catch (NoResultException e) {
			transacao.rollback();
			System.out.println("Não foi localizada Competência de ID: " + id);
			return null;
		} catch (Exception e) {
			transacao.rollback();
			e.printStackTrace();
			return null;
		}
	}
}
