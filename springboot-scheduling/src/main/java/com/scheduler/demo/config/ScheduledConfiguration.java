package com.scheduler.demo.config;

import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 
 * @author Ravishankar.kumar
 *
 */
@Configuration
@EnableScheduling
public class ScheduledConfiguration {

	 // scheduled to run every 5 minutes but only during the 9-to-5 "business hours" on weekdays :: "*/5 * 9-17 * * MON-FRI"
	//  run every morning at 6 AM :: "0 0 6 * * ?"	
	@Scheduled(cron = "${cron.expression}")
	public void executeTask1() {

		System.out.println(Thread.currentThread().getName() + " The Task1 executed at " + new Date());

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 // If a fixed rate execution is desired, simply change the property name specified within the annotation.
	// The following would be executed every 5 seconds measured between the successive start times of each invocation.
	@Scheduled(fixedRate = 5000)
    public void executeTask2() {
        System.out.println(Thread.currentThread().getName()+" The Task2 executed at "+ new Date());
    }
	
	 // For fixed-delay and fixed-rate tasks, 
	// an initial delay may be specified indicating the number of milliseconds to wait before the first execution of the method.
	@Scheduled(initialDelay=1000, fixedRate=5000)
    public void executeTask3() {
        System.out.println(Thread.currentThread().getName()+" The Task3 executed at "+ new Date());
    }

	  // The @Scheduled annotation can be added to a method along with trigger metadata.
	 // The following method would be invoked every 5 seconds with a fixed delay,
	//  meaning that the period will be measured from the completion time of each preceding invocation.
	@Scheduled(fixedDelay=5000)
    public void executeTask4() {
        System.out.println(Thread.currentThread().getName()+" The Task4 executed at "+ new Date());
    }
}
