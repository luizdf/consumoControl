/**
 * 
 */
package org.luiz.consumoControl.delegate;

import java.util.List;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.luiz.consumoControl.vo.Municipio;
import org.luiz.consumoControl.vo.Estado;
import junit.framework.Assert;

/**
 * @author luizantonioalmeida
 *
 */
@SuppressWarnings("deprecation")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MunicipioDelegateTest {

	private MunicipioDelegate delegate = MunicipioDelegate.getInstance();
	
	/**
	 * 
	 */
	@Test
	public void teste1_Incluir() {

		EstadoDelegate.getInstance().incluir(new Estado("TesteMM","MM"));

		Municipio objetoTest = new Municipio();
		objetoTest.setNome("TesteMM");
		objetoTest.setEstado(EstadoDelegate.getInstance().findBySigla("MM"));

		Boolean result = delegate.incluir(objetoTest);
		Assert.assertTrue(result);
	}

	/**
	 *
	 */
	@Test
	public void teste2_Alterar() {
		List<Municipio> objetosTest = delegate.findAll();
		Long id = null;
		
		for (Municipio municipio : objetosTest) {
			if (municipio.getNome().equals("TesteMM")){
				id = municipio.getId();
				break;
			}
		}
		
		Municipio objetoTest = delegate.findById(id);		
		Assert.assertNotNull(objetoTest);

		objetoTest.setNome("TesteMM 2");
		Boolean result = delegate.alterar(objetoTest);
		Assert.assertTrue(result);
		Assert.assertTrue(objetoTest.getNome().equals("TesteMM 2"));
		Assert.assertNotNull(delegate.findById(id));
	}

	/**
	 * 
	 */
	@Test
	public void teste3_FindAll() {
		List<Municipio> objetosTest = delegate.findAll();
		Assert.assertNotNull(objetosTest);
		Assert.assertTrue(objetosTest.size() > 0);
	}

	/**
	 * 
	 */
	@Test
	public void teste5_Excluir() {
		List<Municipio> objetosTest = delegate.findAll();
		Long id = null;

		for (Municipio municipio : objetosTest) {
			if (municipio.getNome().equals("TesteMM 2")){
				id = municipio.getId();
				break;
			}
		}

		Municipio objetoTest = delegate.findById(id);
		Boolean result = delegate.excluir(objetoTest);
		
		EstadoDelegate.getInstance().excluir(EstadoDelegate.getInstance().findBySigla("MM"));

		Assert.assertTrue(result);
		Assert.assertNull(delegate.findById(id));
	} 
}
