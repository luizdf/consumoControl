package org.luiz.consumoControl.factory;

import javax.persistence.*;

import org.luiz.consumoControl.util.PersistenceProperties;

/**
 * @author luizantonioalmeida
 *
 */
@PersistenceContext 
public final class JpaFactory {

    private static EntityManagerFactory factory;
	private static EntityManager entityManager;
  
    static {
		factory = Persistence.createEntityManagerFactory("consumoControlPU", PersistenceProperties.get());
//		factory = Persistence.createEntityManagerFactory("consumoControlPU");
		entityManager = factory.createEntityManager();
    }
    
    public static EntityManager getEntityManager(){
    	return entityManager;
    }
}
