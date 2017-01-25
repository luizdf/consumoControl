/**
 * 
 */
package org.luiz.consumoControl.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import org.luiz.consumoControl.dao.generic.GenericDAO;

/**
 * @author luizantonioalmeida
 *
 */
@SuppressWarnings("unchecked")
public class UsuarioDAO<Usuario> extends GenericDAO<Usuario>{
	/**	
	 * @param em
	 */
	public UsuarioDAO(EntityManager em) {
		super(em);
	}

	@Override
	public List<Usuario> findAll() {
		List<Usuario> result = new ArrayList<Usuario>();
		EntityTransaction transacao = getEm().getTransaction();
		try {
			transacao.begin();
			result = (ArrayList<Usuario>)getEm().createNamedQuery("Usuario.findAll").getResultList();
			transacao.commit();
		} catch (Exception e) {
			transacao.rollback();
			e.printStackTrace();
		}
		return result;
	}

	public Usuario findById(Long id) {
		Usuario result = null;
		EntityTransaction transacao = getEm().getTransaction();
		try {
			Query query;

			query = getEm().createNamedQuery("Usuario.findById");
			query.setParameter("id", id);

			transacao.begin();
			result = (Usuario)query.getSingleResult();
			transacao.commit();

			return result;
		} catch (NoResultException e) {
			transacao.rollback();
			System.out.println("Não foi localizado o Usuário de ID: " + id);
			return null;
		} catch (Exception e) {
			transacao.rollback();
			e.printStackTrace();
			return null;
		}
	}

	public Usuario findByLogin(String login) {
		Usuario result = null;
		EntityTransaction transacao = getEm().getTransaction();
		try {
			Query query;

			query = getEm().createNamedQuery("Usuario.findByLogin");
			query.setParameter("login", login);

			transacao.begin();
			result = (Usuario)query.getSingleResult();
			transacao.commit();

			return result;
		} catch (NoResultException e) {
			transacao.rollback();
			System.out.println("Não foi localizado o Usuário de Login: " + login);
			return null;
		} catch (Exception e) {
			transacao.rollback();
			e.printStackTrace();
			return null;
		}
	}
}
