/**
 * 
 */
package org.luiz.consumoControl.view.app;

import org.apache.wicket.protocol.http.WebApplication;
import org.luiz.consumoControl.view.page.LoginPage;

/**
 * @author luizantonioalmeida
 *
 */
public class Default extends WebApplication {

	/* (non-Javadoc)
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	
	@Override
	public Class<LoginPage> getHomePage() {
		return LoginPage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();

		// add your configuration here
	}
}
