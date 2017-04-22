package com.sagax.stairwell.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sagax.stairwell.dto.StairwellDTO;
import com.sagax.stairwell.util.StairwellUtil;

@Path("stairwell")
public class StairwellResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	public String getStrides(){
		String result = "{total stride: "+ 10+"}";
		
		return result;
	}
	
	@POST
	@Path("/totalStrides")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)	
	public String totalStrides(StairwellDTO dto){
		int totalStride = StairwellUtil.calculateStrides(dto.getListFlight(), dto.getStepsPerStride());
		String result = "{total stride: "+ totalStride+"}";
		
		return result;
	}
}
