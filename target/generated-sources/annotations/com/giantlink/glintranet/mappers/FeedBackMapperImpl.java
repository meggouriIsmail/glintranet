package com.giantlink.glintranet.mappers;

import com.giantlink.glintranet.entities.Employee;
import com.giantlink.glintranet.entities.FeedBack;
import com.giantlink.glintranet.entities.FeedBack.FeedBackBuilder;
import com.giantlink.glintranet.entities.FeedBackType;
import com.giantlink.glintranet.entities.Project;
import com.giantlink.glintranet.entities.Role;
import com.giantlink.glintranet.requests.FeedBackRequest;
import com.giantlink.glintranet.responses.EmployeeResSimplified;
import com.giantlink.glintranet.responses.EmployeeResSimplified.EmployeeResSimplifiedBuilder;
import com.giantlink.glintranet.responses.FeedBackResponse;
import com.giantlink.glintranet.responses.FeedBackTypeResponse;
import com.giantlink.glintranet.responses.FeedBackTypeResponse.FeedBackTypeResponseBuilder;
import com.giantlink.glintranet.responses.ProjectResponse;
import com.giantlink.glintranet.responses.ProjectResponse.ProjectResponseBuilder;
import com.giantlink.glintranet.responses.RoleRes;
import com.giantlink.glintranet.responses.RoleRes.RoleResBuilder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-13T11:16:24+0100",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429, environment: Java 17.0.2 (Eclipse Adoptium)"
)
@Component
public class FeedBackMapperImpl implements FeedBackMapper {

    @Override
    public FeedBack requestToEntity(FeedBackRequest request) {
        if ( request == null ) {
            return null;
        }

        FeedBackBuilder feedBack = FeedBack.builder();

        feedBack.content( request.getContent() );

        return feedBack.build();
    }

    @Override
    public FeedBackResponse entityToResponse(FeedBack feedBack) {
        if ( feedBack == null ) {
            return null;
        }

        FeedBackResponse feedBackResponse = new FeedBackResponse();

        feedBackResponse.setContent( feedBack.getContent() );
        feedBackResponse.setEmployee( employeeToEmployeeResSimplified( feedBack.getEmployee() ) );
        feedBackResponse.setId( feedBack.getId() );
        feedBackResponse.setProject( projectToProjectResponse( feedBack.getProject() ) );
        feedBackResponse.setTimestamp( feedBack.getTimestamp() );
        feedBackResponse.setType( feedBackTypeToFeedBackTypeResponse( feedBack.getType() ) );

        return feedBackResponse;
    }

    @Override
    public List<FeedBackResponse> mapFeedBacks(List<FeedBack> feedBacks) {
        if ( feedBacks == null ) {
            return null;
        }

        List<FeedBackResponse> list = new ArrayList<FeedBackResponse>( feedBacks.size() );
        for ( FeedBack feedBack : feedBacks ) {
            list.add( entityToResponse( feedBack ) );
        }

        return list;
    }

    protected RoleRes roleToRoleRes(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleResBuilder roleRes = RoleRes.builder();

        roleRes.description( role.getDescription() );
        roleRes.id( role.getId() );
        roleRes.name( role.getName() );

        return roleRes.build();
    }

    protected Set<RoleRes> roleSetToRoleResSet(Set<Role> set) {
        if ( set == null ) {
            return null;
        }

        Set<RoleRes> set1 = new HashSet<RoleRes>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Role role : set ) {
            set1.add( roleToRoleRes( role ) );
        }

        return set1;
    }

    protected EmployeeResSimplified employeeToEmployeeResSimplified(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeResSimplifiedBuilder employeeResSimplified = EmployeeResSimplified.builder();

        employeeResSimplified.CIN( employee.getCIN() );
        employeeResSimplified.birthDate( employee.getBirthDate() );
        employeeResSimplified.email( employee.getEmail() );
        employeeResSimplified.firstName( employee.getFirstName() );
        employeeResSimplified.id( employee.getId() );
        employeeResSimplified.lastName( employee.getLastName() );
        employeeResSimplified.phoneNumber( employee.getPhoneNumber() );
        employeeResSimplified.roles( roleSetToRoleResSet( employee.getRoles() ) );
        employeeResSimplified.username( employee.getUsername() );

        return employeeResSimplified.build();
    }

    protected ProjectResponse projectToProjectResponse(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectResponseBuilder projectResponse = ProjectResponse.builder();

        projectResponse.id( project.getId() );
        projectResponse.projectDesc( project.getProjectDesc() );
        projectResponse.projectName( project.getProjectName() );

        return projectResponse.build();
    }

    protected FeedBackTypeResponse feedBackTypeToFeedBackTypeResponse(FeedBackType feedBackType) {
        if ( feedBackType == null ) {
            return null;
        }

        FeedBackTypeResponseBuilder feedBackTypeResponse = FeedBackTypeResponse.builder();

        feedBackTypeResponse.id( feedBackType.getId() );
        feedBackTypeResponse.name( feedBackType.getName() );

        return feedBackTypeResponse.build();
    }
}
