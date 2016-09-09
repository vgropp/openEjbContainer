package de.evelopment.timer;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

public class SimpleContainerBase {

	private EJBContainer container;

	public SimpleContainerBase() {
	}

	@Before
	public void startUp() {
		container = EJBContainer.createEJBContainer();
    Context context = container.getContext();
    try {
      context.bind("inject", this);
    } catch (NamingException e) {
      Assert.fail("Injection failed for "+this.getClass()+": " + e.toString());
    }
	}

	@After
	public void shutdown() {
		container.close();
	}

}
