package com.aeongo.packagemanagementsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aeongo.packagemanagementsystem.request.RecommendationRequest;
@Service
public interface RecommendationService {
	
	public List<Integer> getRecommendationPackagesByTags(List<RecommendationRequest.ActorTag> tags);
	public List<Integer> getRecommendationServicesByTags(List<RecommendationRequest.ActorTag> tags);
}
