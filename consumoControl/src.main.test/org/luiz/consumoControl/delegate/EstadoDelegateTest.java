/**
 * 
 */
package org.luiz.consumoControl.delegate;

import java.util.List;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.luiz.consumoControl.vo.Estado;
import junit.framework.Assert;

/**
 * @author luizantonioalmeida
 *
 */
@SuppressWarnings("deprecation")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EstadoDelegateTest {

	private EstadoDelegate delegate = EstadoDelegate.getInstance();
	
	/**
	 * 
	 */
	@Test
	public void teste1_Incluir() {
        Estado objetoTest = new Estado();
		objetoTest.setNome("Teste");
		objetoTest.setSigla("XX");

		Boolean result = delegate.incluir(objetoTest);
		Assert.assertNotNull(delegate.findBySigla("XX"));
		Assert.assertTrue(result);
	}

	/**
	 *
	 */
	@Test
	public void teste2_Alterar() {
		Estado objetoTest = delegate.findBySigla("XX");
		
		Assert.assertNotNull(objetoTest);

		objetoTest.setSigla("YY");
		Boolean result = delegate.alterar(objetoTest);
		Assert.assertTrue(result);
		Assert.assertNotNull(delegate.findBySigla("YY"));
	}

	/**
	 * 
	 */
	@Test
	public void teste3_FindAll() {
		List<Estado> objetosTest = delegate.findAll();
		Assert.assertNotNull(objetosTest);
		Assert.assertTrue(objetosTest.size() > 0);
	}

	/**
	 * 
	 */
	@Test
	public void teste4_Localizar() {
		Estado objetoTest = delegate.findBySigla("YY");
		Assert.assertNotNull(objetoTest);
		Assert.assertTrue(objetoTest.getNome() == "Teste");
	}

	/**
	 * 
	 */
	@Test
	public void teste5_Excluir() {
		Estado objetoTest = delegate.findBySigla("YY");
		Boolean result = delegate.excluir(objetoTest);
		Assert.assertTrue(result);
		Assert.assertNull(delegate.findBySigla("YY"));
	} 
}
