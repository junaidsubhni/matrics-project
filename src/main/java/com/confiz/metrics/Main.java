package com.confiz.metrics;

import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;

public class Main {
	static final MetricRegistry metrics = new MetricRegistry();
	static Meter meter = new Meter();
	public static void main(String args[]) {
		
		
		
		Thread t1 = new Thread(() -> {
			try {
				for (int i = 0; i < 10; i++) {
					Thread.sleep(100);
					myFunction();
					
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		System.out.println("Meter Count :"+meter.getCount());
//		System.out.println("Mean Rate :"+meter.getMeanRate());
//		System.out.println("One Minute Rate :"+meter.getOneMinuteRate());
//		System.out.println("Five Minute Rate :"+meter.getFiveMinuteRate());
//		System.out.println("Fifteen Minute Rate :"+meter.getFifteenMinuteRate());
//		
		new RepoterTest();
		
	}

	private static void myFunction() {
		meter.mark();
		
	}

	
}