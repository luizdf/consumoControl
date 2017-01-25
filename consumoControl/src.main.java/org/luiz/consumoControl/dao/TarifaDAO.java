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
import org.luiz.consumoControl.vo.Tarifa;

@SuppressWarnings({ "unchecked", "hiding" })
public class TarifaDAO<Tarifa> extends GenericDAO<Tarifa>{
	/**	
	 * @param em
	 */
	public TarifaDAO(EntityManager em) {
		super(em);
	}

	@Override
	public List<Tarifa> findAll() {
		List<Tarifa> result = new ArrayList<Tarifa>();
		EntityTransaction transacao = getEm().getTransaction();
		try {
			transacao.begin();
			result = (ArrayList<Tarifa>)getEm().createNamedQuery("Tarifa.findAll").getResultList();
			transacao.commit();
		} catch (Exception e) {
			transacao.rollback();
			e.printStackTrace();
		}
		return result;
	}

	public Tarifa findById(Long id) {
		Tarifa result = null;
		EntityTransaction transacao = getEm().getTransaction();
		try {
			Query query;

			query = getEm().createNamedQuery("Tarifa.findById");
			query.setParameter("id", id);

			transacao.begin();
			result = (Tarifa)query.getSingleResult();
			transacao.commit();

			return result;
		} catch (NoResultException e) {
			transacao.rollback();
			System.out.println("Não foi localizada Tarifa de ID: " + id);
			return null;
		} catch (Exception e) {
			transacao.rollback();
			e.printStackTrace();
			return null;
		}
	}
}
