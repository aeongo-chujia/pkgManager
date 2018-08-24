package com.aeongo.packagemanagementsystem.service;

import java.util.List;

import com.aeongo.packagemanagementsystem.request.RecommendationRequest;

public interface RecommendationService {
	
	public List<Integer> getRecommendationPackagesByTags(List<RecommendationRequest.ActorTag> tags);

}
