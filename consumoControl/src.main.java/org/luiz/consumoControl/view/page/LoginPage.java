package org.luiz.consumoControl.view.page;

import org.apache.wicket.markup.html.WebPage;
import org.luiz.consumoControl.view.form.FormLogin;
import org.luiz.consumoControl.vo.Usuario;

/**
 * @author luizantonioalmeida
 *
 */
public class LoginPage extends WebPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginPage() {
		super();

		FormLogin formLogin = new FormLogin();
		add(formLogin);
	}

	public LoginPage(Usuario usuario) {
		super();
		FormLogin formLogin = new FormLogin(usuario);
		add(formLogin);
	}
	
}
