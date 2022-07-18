package com.giantlink.glintranet.services;

import java.util.List;

import com.giantlink.glintranet.requests.RoleRequest;
import com.giantlink.glintranet.responses.RoleResponse;

public interface RoleService 
{
	RoleResponse add(RoleRequest request);
	RoleResponse get(Long id);
	List<RoleResponse> getAll();
	RoleResponse update(Long id, RoleRequest request);
	void delete(Long id);
}
