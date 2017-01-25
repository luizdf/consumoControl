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
import org.luiz.consumoControl.vo.Municipio;

@SuppressWarnings({ "unchecked", "hiding" })
public class MunicipioDAO<Municipio> extends GenericDAO<Municipio>{
	/**	
	 * @param em
	 */
	public MunicipioDAO(EntityManager em) {
		super(em);
	}

	@Override
	public List<Municipio> findAll() {
		List<Municipio> result = new ArrayList<Municipio>();
		EntityTransaction transacao = getEm().getTransaction();
		try {
			transacao.begin();
			result = (ArrayList<Municipio>)getEm().createNamedQuery("Municipio.findAll").getResultList();
			transacao.commit();
		} catch (Exception e) {
			transacao.rollback();
			e.printStackTrace();
		}
		return result;
	}

	public Municipio findById(Long id) {
		Municipio result = null;
		EntityTransaction transacao = getEm().getTransaction();
		try {
			Query query;

			query = getEm().createNamedQuery("Municipio.findById");
			query.setParameter("id", id);

			transacao.begin();
			result = (Municipio)query.getSingleResult();
			transacao.commit();

			return result;
		} catch (NoResultException e) {
			transacao.rollback();
			System.out.println("Não foi localizado o Municipio de ID: " + id);
			return null;
		} catch (Exception e) {
			transacao.rollback();
			e.printStackTrace();
			return null;
		}
	}
}
