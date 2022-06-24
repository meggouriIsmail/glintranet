package com.giantlink.glintranet.services;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.giantlink.glintranet.requests.TeamRequest;
import com.giantlink.glintranet.responses.TeamResponse;

public interface TeamService {
	
	TeamResponse add(TeamRequest groupRequest);

	List<TeamResponse> getAll();

	TeamResponse get(Long id);

	void delete(Long id);

	TeamResponse update(Long id, TeamRequest groupRequest);
	
	Map<String, Object> getAllPaginations(String name, Pageable pageable);
}
