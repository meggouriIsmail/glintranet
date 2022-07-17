package com.giantlink.glintranet.mappers;

import com.giantlink.glintranet.entities.Project;
import com.giantlink.glintranet.entities.Project.ProjectBuilder;
import com.giantlink.glintranet.requests.ProjectRequest;
import com.giantlink.glintranet.responses.ProjectResponse;
import com.giantlink.glintranet.responses.ProjectResponse.ProjectResponseBuilder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-13T14:18:48+0100",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429, environment: Java 17.0.2 (Eclipse Adoptium)"
)
@Component
public class ProjectMapperImpl implements ProjectMapper {

    @Override
    public Set<ProjectResponse> mapProject(Set<Project> projects) {
        if ( projects == null ) {
            return null;
        }

        Set<ProjectResponse> set = new HashSet<ProjectResponse>( Math.max( (int) ( projects.size() / .75f ) + 1, 16 ) );
        for ( Project project : projects ) {
            set.add( entityToResponse( project ) );
        }

        return set;
    }

    @Override
    public Set<Project> mapProjectRequest(Set<ProjectRequest> projects) {
        if ( projects == null ) {
            return null;
        }

        Set<Project> set = new HashSet<Project>( Math.max( (int) ( projects.size() / .75f ) + 1, 16 ) );
        for ( ProjectRequest projectRequest : projects ) {
            set.add( requestToEntity( projectRequest ) );
        }

        return set;
    }

    @Override
    public Project requestToEntity(ProjectRequest request) {
        if ( request == null ) {
            return null;
        }

        ProjectBuilder project = Project.builder();

        project.projectDesc( request.getProjectDesc() );
        project.projectName( request.getProjectName() );

        return project.build();
    }

    @Override
    public ProjectResponse entityToResponse(Project entity) {
        if ( entity == null ) {
            return null;
        }

        ProjectResponseBuilder projectResponse = ProjectResponse.builder();

        projectResponse.id( entity.getId() );
        projectResponse.projectDesc( entity.getProjectDesc() );
        projectResponse.projectName( entity.getProjectName() );

        return projectResponse.build();
    }

    @Override
    public List<ProjectResponse> mapProject(List<Project> projects) {
        if ( projects == null ) {
            return null;
        }

        List<ProjectResponse> list = new ArrayList<ProjectResponse>( projects.size() );
        for ( Project project : projects ) {
            list.add( entityToResponse( project ) );
        }

        return list;
    }
}
