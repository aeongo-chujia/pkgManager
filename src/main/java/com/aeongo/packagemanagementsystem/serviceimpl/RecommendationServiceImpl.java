package com.aeongo.packagemanagementsystem.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aeongo.packagemanagementsystem.request.RecommendationRequest.ActorTag;
import com.aeongo.packagemanagementsystem.service.RecommendationService;
@Service
public class RecommendationServiceImpl implements RecommendationService{

	@Override
	public List<Integer> getRecommendationPackagesByTags(List<ActorTag> tags) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> getRecommendationServicesByTags(List<ActorTag> tags) {
		// TODO Auto-generated method stub
		return null;
	}

}
