package com.giantlink.glintranet.services;

import java.util.List;

import com.giantlink.glintranet.requests.DocTypeRequest;
import com.giantlink.glintranet.responses.DocTypeResponse;

public interface DocTypeService 
{
	DocTypeResponse add(DocTypeRequest request);
	DocTypeResponse get(Long id);
	List<DocTypeResponse> getAll();
	DocTypeResponse update(Long id, DocTypeRequest request);
	void delete(Long id);
}
