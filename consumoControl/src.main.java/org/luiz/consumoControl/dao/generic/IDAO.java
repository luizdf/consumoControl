package org.luiz.consumoControl.dao.generic;

import java.util.List;

public interface IDAO<T> {
	/**
	 * 
	 * @param entidade
	 * @return
	 */
	public boolean incluir(T entidade);
	/**
	 * @param entidade
	 * @return
	 */
	public boolean alterar(T entidade);
	/**
	 * @param entidade
	 * @return
	 */
	public boolean excluir(T entidade);
	/**
	 * @param entidade
	 * @return
	 */
	public boolean excluir(List<T> entidades);
}
