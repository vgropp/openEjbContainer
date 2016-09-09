package de.evelopment.timer;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SimpleContainerTest extends SimpleContainerBase {

	private Integer value;
	private @Inject MyTimerService timerService;

	public SimpleContainerTest(Integer value) {
		this.value = value;
	}

	@BeforeClass
	public static void startAll() throws InterruptedException {
		Thread.sleep(25000);
		System.out.println("starting...");
	}

	@Parameters
  public static List<Integer> testData() {
  	List<Integer> liste = new ArrayList<>();
  	for (int i = 0; i<50;i++) {
  		liste.add(i);
  	}
  	return liste;
  }

	@Test
	public void simpleTest() throws Exception {
		timerService.myMethod();
		System.out.println(value);
	}

}
