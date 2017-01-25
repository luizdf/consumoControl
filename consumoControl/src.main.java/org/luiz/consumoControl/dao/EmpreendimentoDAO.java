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
import org.luiz.consumoControl.vo.Empreendimento;

@SuppressWarnings({ "unchecked", "hiding" })
public class EmpreendimentoDAO<Empreendimento> extends GenericDAO<Empreendimento>{
	/**	
	 * @param em
	 */
	public EmpreendimentoDAO(EntityManager em) {
		super(em);
	}

	@Override
	public List<Empreendimento> findAll() {
		List<Empreendimento> result = new ArrayList<Empreendimento>();
		EntityTransaction transacao = getEm().getTransaction();
		try {
			transacao.begin();
			result = (ArrayList<Empreendimento>)getEm().createNamedQuery("Empreendimento.findAll").getResultList();
			transacao.commit();
		} catch (Exception e) {
			transacao.rollback();
			e.printStackTrace();
		}
		return result;
	}

	public Empreendimento findById(Long id) {
		Empreendimento result = null;
		EntityTransaction transacao = getEm().getTransaction();
		try {
			Query query;

			query = getEm().createNamedQuery("Empreendimento.findById");
			query.setParameter("id", id);

			transacao.begin();
			result = (Empreendimento)query.getSingleResult();
			transacao.commit();

			return result;
		} catch (NoResultException e) {
			transacao.rollback();
			System.out.println("Não foi localizado Empreendimento de ID: " + id);
			return null;
		} catch (Exception e) {
			transacao.rollback();
			e.printStackTrace();
			return null;
		}
	}
}
