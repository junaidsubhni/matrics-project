package com.confiz.metrics;

import com.codahale.metrics.RatioGauge;

public class GaugeTest {
	public static void main(String[] args) {
		RatioGauge ratioGauge = new AttendanceRatioGauge(15, 20);
		 
		System.out.println("Ratio Gauge :"+ratioGauge.getValue());
	}
}
