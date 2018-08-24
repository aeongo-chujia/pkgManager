package com.aeongo.packagemanagementsystem.response;

import java.util.List;

import lombok.Data;

@Data
public class RecommendationResponse {
	
	private String msg;
	private Integer status;
	private List<Model> data;
	
	
	@Data
	public static class Model{
		private String itemCategory;
		private String itemId;
		private Integer modelId;
	}

}
