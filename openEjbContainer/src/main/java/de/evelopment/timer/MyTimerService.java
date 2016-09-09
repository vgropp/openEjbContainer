package de.evelopment.timer;

import javax.annotation.Resource;
import javax.ejb.ScheduleExpression;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

@Stateless
public class MyTimerService {

  private @Resource TimerService timerService;

  public void start() {
  	ScheduleExpression schedule = new ScheduleExpression();
  	schedule.dayOfWeek("Mon");
  	schedule.hour("12-17, 23");
  	timerService.createCalendarTimer(schedule);
  }

  public void myMethod() {
  	System.out.println(timerService + " init done");
  }

  @Timeout
  public void scheduleTimer(Timer time) {
  	System.out.println("MyTimerService: timeout occurred");
  }

}
