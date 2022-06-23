package com.giantlink.glintranet.services;

import java.util.List;

import com.giantlink.glintranet.requests.TagRequest;
import com.giantlink.glintranet.responses.TagResponse;

public interface TagService 
{
	TagResponse add(TagRequest request);
	TagResponse get(Long id);
	List<TagResponse> getAll();
	TagResponse update(Long id, TagRequest request);
	void delete(Long id);
}
