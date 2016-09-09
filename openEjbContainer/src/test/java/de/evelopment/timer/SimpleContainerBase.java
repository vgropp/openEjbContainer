package de.evelopment.timer;

import java.util.Properties;

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
		Properties p = new Properties();
		p.put("MyJmsResourceAdapter", "new://Resource?type=ActiveMQResourceAdapter");
		p.put("MyJmsResourceAdapter.ServerUrl", "tcp://someHostName:61616");
		p.put("MyJmsResourceAdapter.BrokerXmlConfig", "");

		p.put("MyJMSContainer", "new://Container?type=MESSAGE");
		p.put("MyJMSContainer.ResourceAdapter", "MyJmsResourceAdapter");

		p.put("SocketResourceAdapter", "new://Resource?type=ActiveMQResourceAdapter");
		p.put("SocketResourceAdapter.BrokerXmlConfig", "");
		p.put("MyOtherContainer", "new://Container?type=MESSAGE");
		p.put("MyOtherContainer.ResourceAdapter", "SocketResourceAdapter");

		container = EJBContainer.createEJBContainer(p);
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
