package com.sagax.stairwell.util;

import java.util.Iterator;
import java.util.List;

public class StairwellUtil {
	
	public static int calculateStrides(List<Integer> listFlight, int stepsPerStride) {
		int totalStride = 0;
		int steps = 0;
				
		for(Iterator<Integer> iterator = listFlight.iterator(); iterator.hasNext();){
			steps =  iterator.next();
			int strideByFly = 0;
			strideByFly = steps/stepsPerStride;
			totalStride += strideByFly;
			
			if((strideByFly * stepsPerStride) < steps){
				totalStride += 1;
			}
			if(iterator.hasNext()) totalStride +=2;
		}
		return totalStride;
	}
}
