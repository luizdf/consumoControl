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
import org.luiz.consumoControl.vo.Faixa;

@SuppressWarnings({ "unchecked", "hiding" })
public class FaixaDAO<Faixa> extends GenericDAO<Faixa>{
	/**	
	 * @param em
	 */
	public FaixaDAO(EntityManager em) {
		super(em);
	}

	@Override
	public List<Faixa> findAll() {
		List<Faixa> result = new ArrayList<Faixa>();
		EntityTransaction transacao = getEm().getTransaction();
		try {
			transacao.begin();
			result = (ArrayList<Faixa>)getEm().createNamedQuery("Faixa.findAll").getResultList();
			transacao.commit();
		} catch (Exception e) {
			transacao.rollback();
			e.printStackTrace();
		}
		return result;
	}

	public Faixa findById(Long id) {
		Faixa result = null;
		EntityTransaction transacao = getEm().getTransaction();
		try {
			Query query;

			query = getEm().createNamedQuery("Faixa.findById");
			query.setParameter("id", id);

			transacao.begin();
			result = (Faixa)query.getSingleResult();
			transacao.commit();

			return result;
		} catch (NoResultException e) {
			transacao.rollback();
			System.out.println("Não foi localizada Faixa de ID: " + id);
			return null;
		} catch (Exception e) {
			transacao.rollback();
			e.printStackTrace();
			return null;
		}
	}
}
