package com.sagax.stairwell.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class StairwellDTO {
	
	@JsonProperty("listFlight")
	private List<Integer> listFlight = new ArrayList<>();
	 @JsonProperty("stepsPerStride")
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

	public String toJson() {
		return new Gson().toJson(this);
	}
	
}
