package com.giantlink.glintranet.services;

import java.util.List;

import com.giantlink.glintranet.requests.FeedBackRequest;
import com.giantlink.glintranet.responses.FeedBackResponse;

public interface FeedBackService {
	FeedBackResponse add(FeedBackRequest request);
	FeedBackResponse get(Long id);
	List<FeedBackResponse> getAll();
	List<FeedBackResponse> getAllByProject(Long projectId);
	
	void delete(Long id);
	
	
}
