package com.giantlink.glintranet.mappers;

import java.util.List;
import java.util.Set;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.giantlink.glintranet.entities.Project;
import com.giantlink.glintranet.requests.ProjectRequest;
import com.giantlink.glintranet.responses.ProjectResponse;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProjectMapper {
	
	ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);
	
	Set<ProjectResponse> mapProject(Set<Project> projects);
	Set<Project> mapProjectRequest(Set<ProjectRequest> projects);
	
	Project requestToEntity(ProjectRequest request);

	ProjectResponse entityToResponse(Project entity);
	List<ProjectResponse> mapProject(List<Project> projects);

}
