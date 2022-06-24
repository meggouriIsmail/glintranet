package com.giantlink.glintranet.services;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.giantlink.glintranet.requests.ProjectRequest;
import com.giantlink.glintranet.responses.ProjectResponse;

public interface ProjectService {

	
	ProjectResponse add(ProjectRequest projectRequest);

	List<ProjectResponse> getAll();

	ProjectResponse get(Long id);

	void delete(Long id);

	ProjectResponse update(Long id, ProjectRequest projectRequest);
	
	Map<String, Object> getAllPaginations(String name, Pageable pageable);
}
