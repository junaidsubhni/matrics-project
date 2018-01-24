package com.confiz.metrics;

import java.util.concurrent.TimeUnit;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Counter;
import com.codahale.metrics.Histogram;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;

public class RepoterTest {
	
	public MetricRegistry metricRegistry = new MetricRegistry();

	public RepoterTest() {

		
		 
		Meter meter = metricRegistry.meter("My Meter 1");
		meter.mark(2);
		meter.mark(200);
		
		Meter meter2 = metricRegistry.meter("My Meter 2");
		meter2.mark();
		meter2.mark(20);
		
		Histogram histogram = metricRegistry.histogram("My Histogram");
		histogram.update(12);
		histogram.update(17);
		histogram.update(19);
		histogram.update(97);
		histogram.update(112);
		histogram.update(177);
		histogram.update(192);
		histogram.update(197);
		histogram.update(199);
		histogram.update(200);
		
		Counter counter = metricRegistry.counter("My Counter");
		counter.inc();
		counter.inc();
		counter.dec();
		
		
		
		ConsoleReporter reporter = ConsoleReporter.forRegistry(metricRegistry).build();
		reporter.start(5, TimeUnit.MICROSECONDS);
		reporter.report();
	}

}
