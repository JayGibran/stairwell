package com.sagax.stairwell.util;

import java.util.Iterator;
import java.util.List;

/**
 * @author JayGibran
 *
 */
public class StairwellUtil {
	
	public static int calculateStrides(List<Integer> listFlight, int stepsPerStride) {
		int totalStride = 0;
		int flight = 0;
				
		for(Iterator<Integer> iterator = listFlight.iterator(); iterator.hasNext();){
			flight =  iterator.next();
			int strideByFlight = 0;
			strideByFlight = flight/stepsPerStride;
			totalStride += strideByFlight;
			
			if((strideByFlight * stepsPerStride) < flight) totalStride += 1;
				
			if(iterator.hasNext()) totalStride += 2;
		}
		return totalStride;
	}
}
