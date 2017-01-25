/**
 *
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
import org.luiz.consumoControl.vo.Pessoa;

@SuppressWarnings({ "unchecked", "hiding" })
public class PessoaDAO<Pessoa> extends GenericDAO<Pessoa>{
	/**	
	 * @param em
	 */
	public PessoaDAO(EntityManager em) {
		super(em);
	}

	@Override
	public List<Pessoa> findAll() {
		List<Pessoa> result = new ArrayList<Pessoa>();
		EntityTransaction transacao = getEm().getTransaction();
		try {
			transacao.begin();
			result = (ArrayList<Pessoa>)getEm().createNamedQuery("Pessoa.findAll").getResultList();
			transacao.commit();
		} catch (Exception e) {
			transacao.rollback();
			e.printStackTrace();
		}
		return result;
	}

	public Pessoa findById(Long id) {
		Pessoa result = null;
		EntityTransaction transacao = getEm().getTransaction();
		try {
			Query query;

			query = getEm().createNamedQuery("Pessoa.findById");
			query.setParameter("id", id);

			transacao.begin();
			result = (Pessoa)query.getSingleResult();
			transacao.commit();

			return result;
		} catch (NoResultException e) {
			transacao.rollback();
			System.out.println("Não foi localizada Pessoa de ID: " + id);
			return null;
		} catch (Exception e) {
			transacao.rollback();
			e.printStackTrace();
			return null;
		}
	}
}
