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
import org.luiz.consumoControl.vo.UnidadeMedida;

@SuppressWarnings({ "unchecked", "hiding" })
public class UnidadeMedidaDAO<UnidadeMedida> extends GenericDAO<UnidadeMedida>{
	/**	
	 * @param em
	 */
	public UnidadeMedidaDAO(EntityManager em) {
		super(em);
	}

	@Override
	public List<UnidadeMedida> findAll() {
		List<UnidadeMedida> result = new ArrayList<UnidadeMedida>();
		EntityTransaction transacao = getEm().getTransaction();
		try {
			transacao.begin();
			result = (ArrayList<UnidadeMedida>)getEm().createNamedQuery("UnidadeMedida.findAll").getResultList();
			transacao.commit();
		} catch (Exception e) {
			transacao.rollback();
			e.printStackTrace();
		}
		return result;
	}

	public UnidadeMedida findById(Long id) {
		UnidadeMedida result = null;
		EntityTransaction transacao = getEm().getTransaction();
		try {
			Query query;

			query = getEm().createNamedQuery("UnidadeMedida.findById");
			query.setParameter("id", id);

			transacao.begin();
			result = (UnidadeMedida)query.getSingleResult();
			transacao.commit();

			return result;
		} catch (NoResultException e) {
			transacao.rollback();
			System.out.println("Não foi localizada Unidade de Medida de ID: " + id);
			return null;
		} catch (Exception e) {
			transacao.rollback();
			e.printStackTrace();
			return null;
		}
	}
}
