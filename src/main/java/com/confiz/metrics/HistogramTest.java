package com.confiz.metrics;

import com.codahale.metrics.Histogram;
import com.codahale.metrics.Snapshot;
import com.codahale.metrics.UniformReservoir;

public class HistogramTest {
	public static void main(String[] args) {
		Histogram histogram = new Histogram(new UniformReservoir());
		histogram.update(5);

		System.out.println("Count : " + histogram.getCount());

		Snapshot snapshot1 = histogram.getSnapshot();
		System.out.println("snapshot length : " + snapshot1.getValues().length);

		histogram.update(20);
		histogram.update(220);
		histogram.update(203);
		histogram.update(120);
		histogram.update(420);
		histogram.update(320);
		histogram.update(520);
		histogram.update(205);
		System.out.println("Count : " + histogram.getCount());

		Snapshot snapshot2 = histogram.getSnapshot();

		System.out.println("Max value : " + snapshot2.getMax());
		System.out.println("Min Value : " + snapshot2.getMin());
		System.out.println("Mean : " + snapshot2.getMean());
		System.out.println("75 percentil : " + snapshot2.get75thPercentile());
	}
}
