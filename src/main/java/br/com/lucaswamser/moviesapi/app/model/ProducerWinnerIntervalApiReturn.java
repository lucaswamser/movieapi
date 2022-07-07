package br.com.lucaswamser.moviesapi.app.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProducerWinnerIntervalApiReturn {
	

	List<Map<String,Object>> min;
	List<Map<String,Object>> max;
	public ProducerWinnerIntervalApiReturn(List<Map<String,Object>> queryReturn) {
	    this.min =  new ArrayList<>(queryReturn);
	    this.max = new ArrayList<>(queryReturn);
	    Collections.reverse(this.max);
	    
	    this.max = this.max.stream().limit(2).collect(Collectors.toList());
	    this.min = this.min.stream().limit(2).collect(Collectors.toList());
		// TODO Auto-generated constructor stub
	}

	public List<Map<String, Object>> getMax() {
		return max;
	}

	public void setMax(List<Map<String, Object>> max) {
		this.max = max;
	}

	public List<Map<String, Object>> getMin() {
		return min;
	}

	public void setMin(List<Map<String, Object>> min) {
		this.min = min;
	}
	
	
	

}
