package com.giantlink.glintranet.mappers;

import java.util.List;
import java.util.Set;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.giantlink.glintranet.entities.Team;
import com.giantlink.glintranet.requests.TeamRequest;
import com.giantlink.glintranet.responses.TeamResponse;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface TeamMapper {
	
	TeamMapper INSTANCE = Mappers.getMapper(TeamMapper.class);

	Set<TeamResponse> mapTeam(Set<Team> groups);
	
	List<TeamResponse> mapTeam(List<Team> groups);
	
	Team requestToEntity(TeamRequest request);

	TeamResponse entityToResponse(Team entity);

}
