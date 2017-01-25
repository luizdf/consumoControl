/**
 * 
 */
package org.luiz.consumoControl.delegate;

import java.util.List;
import junit.framework.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.luiz.consumoControl.vo.Usuario;

/**
 * @author luizantonioalmeida
 *
 */
@SuppressWarnings("deprecation")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioDelegateTest {

	private UsuarioDelegate delegate = UsuarioDelegate.getInstance();
	
	/**
	 * 
	 */
	@Test
	public void teste1_Incluir() {
		Usuario objetoTest = new Usuario();
		objetoTest.setNome("Rayanne Negreiros");
		objetoTest.setLogin("rayanne");
		objetoTest.setSenha("12345");

		Boolean result = delegate.incluir(objetoTest);
		Assert.assertNotNull(delegate.findByLogin("rayanne"));
		Assert.assertTrue(result);
	}

	/**
	 *
	 */
	@Test
	public void teste2_Alterar() {
		Usuario objetoTest = delegate.findByLogin("rayanne");
		
		Assert.assertNotNull(objetoTest);

		objetoTest.setLogin("rayanne2");
		objetoTest.setSenha("123456");
		
		Boolean result = delegate.alterar(objetoTest);
		Assert.assertTrue(result);
		Assert.assertNotNull(delegate.findByLogin("rayanne2"));
	}

	/**
	 * 
	 */
	@Test
	public void teste3_FindAll() {
		List<Usuario> usuariosTest = delegate.findAll();
		Assert.assertNotNull(usuariosTest);
		Assert.assertTrue(usuariosTest.size() > 0);
	}

	/**
	 * 
	 */
	@Test
	public void teste4_Localizar() {
		Usuario objetoTest = delegate.findByLogin("rayanne2");
		Assert.assertNotNull(objetoTest);
		Assert.assertTrue(objetoTest.getSenha() == "123456");
	}

	/**
	 * 
	 */
	@Test
	public void teste5_Excluir() {
		Usuario objetoTest = delegate.findByLogin("rayanne2");
		Boolean result = delegate.excluir(objetoTest);
		Assert.assertTrue(result);
		Assert.assertNull(delegate.findByLogin("rayanne2"));
	}
}
