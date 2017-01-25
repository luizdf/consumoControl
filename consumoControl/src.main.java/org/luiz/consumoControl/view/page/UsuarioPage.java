/**
 * 
 */
package org.luiz.consumoControl.view.page;

import org.luiz.consumoControl.view.form.FormCadUsuario;

/**
 * @author luizantonioalmeida
 *
 */
public class UsuarioPage extends BasePage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioPage(){
		super();
		FormCadUsuario formCadUsuario = new FormCadUsuario(getUsuario());
		add(formCadUsuario);
	}
}
