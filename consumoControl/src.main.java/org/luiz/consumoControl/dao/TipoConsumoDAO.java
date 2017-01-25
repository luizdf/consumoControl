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
import org.luiz.consumoControl.vo.TipoConsumo;

@SuppressWarnings({ "unchecked", "hiding" })
public class TipoConsumoDAO<TipoConsumo> extends GenericDAO<TipoConsumo>{
	/**	
	 * @param em
	 */
	public TipoConsumoDAO(EntityManager em) {
		super(em);
	}

	@Override
	public List<TipoConsumo> findAll() {
		List<TipoConsumo> result = new ArrayList<TipoConsumo>();
		EntityTransaction transacao = getEm().getTransaction();
		try {
			transacao.begin();
			result = (ArrayList<TipoConsumo>)getEm().createNamedQuery("TipoConsumo.findAll").getResultList();
			transacao.commit();
		} catch (Exception e) {
			transacao.rollback();
			e.printStackTrace();
		}
		return result;
	}

	public TipoConsumo findById(Long id) {
		TipoConsumo result = null;
		EntityTransaction transacao = getEm().getTransaction();
		try {
			Query query;

			query = getEm().createNamedQuery("TipoConsumo.findById");
			query.setParameter("id", id);

			transacao.begin();
			result = (TipoConsumo)query.getSingleResult();
			transacao.commit();

			return result;
		} catch (NoResultException e) {
			transacao.rollback();
			System.out.println("Não foi localizado Tipo de Consumo de ID: " + id);
			return null;
		} catch (Exception e) {
			transacao.rollback();
			e.printStackTrace();
			return null;
		}
	}
}
