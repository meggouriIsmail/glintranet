package com.giantlink.glintranet.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.giantlink.glintranet.entities.Role;
import com.giantlink.glintranet.requests.RoleRequest;
import com.giantlink.glintranet.responses.RoleResponse;

@Mapper(componentModel = "spring")
public interface RoleMapper 
{
	RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
	
	Role requestToEntity(RoleRequest request);
	RoleResponse entityToResoponse(Role role);
}
