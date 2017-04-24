package com.sagax.stairwell.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JayGibran
 *
 */

public class StairwellDTO {
	
	private List<Integer> listFlight = new ArrayList<>();
	private int stepsPerStride;
	
	public List<Integer> getListFlight() {
		return listFlight;
	}

	public void setListFlight(List<Integer> lista) {
		this.listFlight = lista;
	}

	public int getStepsPerStride() {
		return stepsPerStride;
	}

	public void setStepsPerStride(int stride) {
		this.stepsPerStride = stride;
	}

}
