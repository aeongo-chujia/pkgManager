package com.aeongo.packagemanagementsystem.request;

import java.util.List;

import lombok.Data;


@Data
public class RecommendationRequest {
	
	private String actorId;
	private String itemCategory;
	private List<ActorTag> actorTags;
	
	@Data
	public static class ActorTag{
		private String actorTagCategory;
		private String actorTagValue;
	}

}
