package com.confiz.metrics;

import java.util.concurrent.TimeUnit;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;

public class TimerTest {
	
	static final MetricRegistry metrics = new MetricRegistry();
	
	private final static Timer responses = metrics.timer("response");

	static Timer.Context context;
	public static void handleRequest() {
	    context = responses.time();
	    try {
	        try {
	        	for (int i = 0; i < 5; i++) {
	        		Thread.sleep(1000);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    } finally {
	    	System.out.println("Execution time of Handle request : " +context.stop());
	    }
	}

	public static void main(String[] args) {
		
		handleRequest();
		
		Timer timer = new Timer();
		Timer.Context context1 = timer.time();
		try {
			TimeUnit.SECONDS.sleep(3);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Time elasped : " +context1.stop());
		
	}

}
