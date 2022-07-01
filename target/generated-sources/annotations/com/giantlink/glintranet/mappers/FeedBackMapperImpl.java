package com.giantlink.glintranet.mappers;

import com.giantlink.glintranet.entities.Employee;
import com.giantlink.glintranet.entities.FeedBack;
import com.giantlink.glintranet.entities.FeedBack.FeedBackBuilder;
import com.giantlink.glintranet.entities.FeedBackType;
import com.giantlink.glintranet.entities.Project;
import com.giantlink.glintranet.requests.FeedBackRequest;
import com.giantlink.glintranet.responses.EmployeeResSimplified;
import com.giantlink.glintranet.responses.EmployeeResSimplified.EmployeeResSimplifiedBuilder;
import com.giantlink.glintranet.responses.FeedBackResponse;
import com.giantlink.glintranet.responses.FeedBackTypeResponse;
import com.giantlink.glintranet.responses.FeedBackTypeResponse.FeedBackTypeResponseBuilder;
import com.giantlink.glintranet.responses.ProjectResponse;
import com.giantlink.glintranet.responses.ProjectResponse.ProjectResponseBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-01T15:31:13+0100",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429, environment: Java 17.0.1 (Eclipse Adoptium)"
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
        employeeResSimplified.password( employee.getPassword() );
        employeeResSimplified.phoneNumber( employee.getPhoneNumber() );
        employeeResSimplified.role( employee.getRole() );
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
