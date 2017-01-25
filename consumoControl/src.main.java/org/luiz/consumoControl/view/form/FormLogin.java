package org.luiz.consumoControl.view.form;

import org.apache.wicket.markup.html.form.EmailTextField;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.model.PropertyModel;
import org.luiz.consumoControl.delegate.UsuarioDelegate;
import org.luiz.consumoControl.view.app.Sessao;
import org.luiz.consumoControl.view.page.Index;
import org.luiz.consumoControl.vo.Usuario;

/**
 * @author luizantonioalmeida
 *
 */
public class FormLogin extends Form<Object>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private Usuario usuario;

	public FormLogin() {
		super("formLogin");
		usuario = new Usuario();
		carregaCamposFormulario();
	}
	
	public FormLogin(Usuario usuario) {
		super("formLogin");

		if (usuario != null) {
			this.usuario = usuario;
		}

		carregaCamposFormulario();
	}

	private void carregaCamposFormulario() {
        PropertyModel<String> mdlLogin = new PropertyModel<String>(this.usuario, "login");
        PropertyModel<String> mdlSenha = new PropertyModel<String>(this.usuario, "senha");
        
        EmailTextField campoLogin = new EmailTextField("login",mdlLogin);
        add(campoLogin);

        PasswordTextField campoSenha = new PasswordTextField("senha",mdlSenha);
        add(campoSenha);
	}

	@Override
	protected void onSubmit() {
		super.onSubmit();
				
		if (this.usuario.getLogin() != null){
			UsuarioDelegate usuarioDelegate = UsuarioDelegate.getInstance();
			Usuario usuario = usuarioDelegate.findByLogin(this.usuario.getLogin());

			if (usuario != null){
				if (usuario.getSenha().equals(this.usuario.getSenha())){
					Sessao.getInstancia(getRequest()).setAtributo("usuario", usuario);
					setResponsePage(Index.class);
				}
				else{
//					setMsgErro("Senha Incorreta");
				}
			}
			else{
//				setMsgErro("Usuário Não Encontrado");
			}
		}
		else{
//			setMsgErro("Üsuário Não Informado");
		}
	}
}
