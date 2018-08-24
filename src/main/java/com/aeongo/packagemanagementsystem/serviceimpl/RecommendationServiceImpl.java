package com.aeongo.packagemanagementsystem.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aeongo.packagemanagementsystem.request.RecommendationRequest;
import com.aeongo.packagemanagementsystem.response.RecommendationResponse;
import com.aeongo.packagemanagementsystem.service.RecommendationService;

@Service
public class RecommendationServiceImpl implements RecommendationService {

	private RestTemplate restTemplate;
	
	@Value(value="${recommendationurl}") 
	private String recommendationUrl;
	
	public RecommendationServiceImpl() {
		this.restTemplate = new RestTemplate();
	}
	
	@Override
	public List<Integer> getRecommendationPackagesByTags(List<RecommendationRequest.ActorTag> tags) {
		RecommendationRequest request = new RecommendationRequest();
		request.setActorId("");
		request.setItemCategory("package");
		request.setActorTags(tags);
		
		RecommendationResponse result = restTemplate.postForObject(recommendationUrl, request, RecommendationResponse.class);
		List<Integer> packages = result.getData().stream().map(model -> Integer.parseInt(model.getItemId())).collect(Collectors.toList());
		return packages;
	}

}
