package de.evelopment.timer;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
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
    Properties p = loadProperties("openejb.properties");
    container = EJBContainer.createEJBContainer(p);
    Context context = container.getContext();
    try {
      context.bind("inject", this);
    } catch (NamingException e) {
      Assert.fail("Injection failed for " + this.getClass() + ": " + e.toString());
    }
  }


  private static Properties loadProperties(String filename) {
    URL url = getURL("./",filename);
    Properties jndi = new Properties();
    try {
      jndi.load(url.openStream());
    } catch (IOException e) {
      Assert.fail("Loading properties failed: " + e.toString());
    }
    return jndi;
  }

  private static URL getURL(String dir, String filename) {
    // search in classpath
    URL url = SimpleContainerBase.class.getResource("/" + dir + "/" + filename);
    if (url == null) {
      try {
        // search in work-directory
        File file = new File(dir, filename);
        if (file.exists()) {
          url = file.toURI().toURL();
        } 
        if (url == null) {
          url = new URL("file:" + dir + "/" + filename);
        }
      } catch (MalformedURLException me) {
      }
    }
    return url;
  }

  @After
  public void shutdown() {
    container.close();
  }

}
