package com.giantlink.glintranet.services;

import java.util.List;

import com.giantlink.glintranet.requests.SectionRequest;
import com.giantlink.glintranet.responses.SectionResponse;

public interface SectionService 
{
	SectionResponse add(SectionRequest request);
	SectionResponse get(Long id) ;
	List<SectionResponse> getAll();
	SectionResponse update(Long id, SectionRequest request);
	void delete(Long id);
}
