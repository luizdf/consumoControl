package org.luiz.consumoControl.view.form;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.luiz.consumoControl.delegate.UsuarioDelegate;
import org.luiz.consumoControl.view.page.Index;
import org.luiz.consumoControl.view.page.UsuarioPage;
import org.luiz.consumoControl.vo.Usuario;

/**
 * @author luizantonioalmeida
 *
 */
@SuppressWarnings("unused")
public class FormCadUsuario extends Form<Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario usuario = new Usuario();
	private String login;
	private String senhaRep;
	
	public FormCadUsuario(Usuario usuario) {
		super("formCadUsuario");

		if (usuario != null) {
			this.usuario = usuario;
		}
		
		this.login = this.usuario.getLogin();
		carregaCamposFormulario();
	}

	private void carregaCamposFormulario() {
        PropertyModel<String> mdlNome = new PropertyModel<String>(this.usuario, "nome");
        PropertyModel<String> mdlLogin = new PropertyModel<String>(this, "login");
        PropertyModel<String> mdlSenha = new PropertyModel<String>(this.usuario, "senha");
        PropertyModel<String> mdlRepitaSenha = new PropertyModel<String>(this, "senhaRep");
        
        TextField<String> campoNome = new TextField<String>("txtNome",mdlNome);
        TextField<String> campoLogin = new TextField<String>("txtLogin",mdlLogin);
        PasswordTextField campoSenha = new PasswordTextField("txtSenha",mdlSenha);
        PasswordTextField campoRepitaSenha = new PasswordTextField("txtRepitaSenha",mdlRepitaSenha);
        
//      campoSenha.add(new AttributeModifier("onclick", "return confirm('Deseja Sair?');"));

        add(campoNome);
        add(campoLogin);
        add(campoSenha);
        add(campoRepitaSenha);
	}

	@Override
	protected void onSubmit() {
		super.onSubmit();

		if (this.usuario.getSenha().equals(senhaRep)){
			UsuarioDelegate usuarioDelegate = UsuarioDelegate.getInstance();
			usuarioDelegate.alterar(usuario);
			setResponsePage(Index.class);
//		}
//		else{
//			setMsgErro("Üsuário Não Informado");
		}
	}
}