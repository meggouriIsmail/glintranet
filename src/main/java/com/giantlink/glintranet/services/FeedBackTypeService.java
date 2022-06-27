package com.giantlink.glintranet.services;

import java.util.List;

import com.giantlink.glintranet.requests.FeedBackTypeRequest;
import com.giantlink.glintranet.responses.FeedBackTypeResponse;


public interface FeedBackTypeService 
{
	FeedBackTypeResponse add(FeedBackTypeRequest request);
	FeedBackTypeResponse get(Long id);
	List<FeedBackTypeResponse>  getAll();
	FeedBackTypeResponse update(Long id, FeedBackTypeRequest request);
	void delete(Long id);

}
