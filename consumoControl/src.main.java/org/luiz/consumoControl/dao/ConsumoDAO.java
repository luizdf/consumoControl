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
import org.luiz.consumoControl.vo.Consumo;

@SuppressWarnings({ "unchecked" })
public class ConsumoDAO<Competencia> extends GenericDAO<Consumo>{
	/**	
	 * @param em
	 */
	public ConsumoDAO(EntityManager em) {
		super(em);
	}

	@Override
	public List<Consumo> findAll() {
		List<Consumo> result = new ArrayList<Consumo>();
		EntityTransaction transacao = getEm().getTransaction();
		try {
			transacao.begin();
			result = (ArrayList<Consumo>)getEm().createNamedQuery("Consumo.findAll").getResultList();
			transacao.commit();
		} catch (Exception e) {
			transacao.rollback();
			e.printStackTrace();
		}
		return result;
	}

	public Consumo findById(Long id) {
		Consumo result = null;
		EntityTransaction transacao = getEm().getTransaction();
		try {
			Query query;

			query = getEm().createNamedQuery("Consumo.findById");
			query.setParameter("id", id);

			transacao.begin();
			result = (Consumo)query.getSingleResult();
			transacao.commit();

			return result;
		} catch (NoResultException e) {
			transacao.rollback();
			System.out.println("Não foi localizado Consumo de ID: " + id);
			return null;
		} catch (Exception e) {
			transacao.rollback();
			e.printStackTrace();
			return null;
		}
	}
}
