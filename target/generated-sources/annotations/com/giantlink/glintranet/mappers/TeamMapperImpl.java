package com.giantlink.glintranet.mappers;

import com.giantlink.glintranet.entities.Employee;
import com.giantlink.glintranet.entities.Employee.EmployeeBuilder;
import com.giantlink.glintranet.entities.Project;
import com.giantlink.glintranet.entities.Project.ProjectBuilder;
import com.giantlink.glintranet.entities.Role;
import com.giantlink.glintranet.entities.Role.RoleBuilder;
import com.giantlink.glintranet.entities.Team;
import com.giantlink.glintranet.entities.Team.TeamBuilder;
import com.giantlink.glintranet.requests.EmployeeRequest;
import com.giantlink.glintranet.requests.ProjectRequest;
import com.giantlink.glintranet.requests.RoleRequest;
import com.giantlink.glintranet.requests.TeamRequest;
import com.giantlink.glintranet.responses.TeamResponse;
import com.giantlink.glintranet.responses.TeamResponse.TeamResponseBuilder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-22T09:12:14+0100",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429, environment: Java 17.0.1 (Eclipse Adoptium)"
)
@Component
public class TeamMapperImpl implements TeamMapper {

    @Override
    public Set<TeamResponse> mapTeam(Set<Team> groups) {
        if ( groups == null ) {
            return null;
        }

        Set<TeamResponse> set = new HashSet<TeamResponse>( Math.max( (int) ( groups.size() / .75f ) + 1, 16 ) );
        for ( Team team : groups ) {
            set.add( entityToResponse( team ) );
        }

        return set;
    }

    @Override
    public List<TeamResponse> mapTeam(List<Team> groups) {
        if ( groups == null ) {
            return null;
        }

        List<TeamResponse> list = new ArrayList<TeamResponse>( groups.size() );
        for ( Team team : groups ) {
            list.add( entityToResponse( team ) );
        }

        return list;
    }

    @Override
    public Team requestToEntity(TeamRequest request) {
        if ( request == null ) {
            return null;
        }

        TeamBuilder team = Team.builder();

        team.description( request.getDescription() );
        team.employees( employeeRequestSetToEmployeeSet( request.getEmployees() ) );
        team.name( request.getName() );
        team.projects( projectRequestSetToProjectSet( request.getProjects() ) );

        return team.build();
    }

    @Override
    public TeamResponse entityToResponse(Team entity) {
        if ( entity == null ) {
            return null;
        }

        TeamResponseBuilder teamResponse = TeamResponse.builder();

        teamResponse.description( entity.getDescription() );
        teamResponse.id( entity.getId() );
        teamResponse.name( entity.getName() );

        return teamResponse.build();
    }

    protected Role roleRequestToRole(RoleRequest roleRequest) {
        if ( roleRequest == null ) {
            return null;
        }

        RoleBuilder role = Role.builder();

        role.description( roleRequest.getDescription() );
        role.name( roleRequest.getName() );

        return role.build();
    }

    protected Set<Role> roleRequestListToRoleSet(List<RoleRequest> list) {
        if ( list == null ) {
            return null;
        }

        Set<Role> set = new HashSet<Role>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( RoleRequest roleRequest : list ) {
            set.add( roleRequestToRole( roleRequest ) );
        }

        return set;
    }

    protected Employee employeeRequestToEmployee(EmployeeRequest employeeRequest) {
        if ( employeeRequest == null ) {
            return null;
        }

        EmployeeBuilder employee = Employee.builder();

        employee.CIN( employeeRequest.getCIN() );
        employee.birthDate( employeeRequest.getBirthDate() );
        employee.email( employeeRequest.getEmail() );
        employee.firstName( employeeRequest.getFirstName() );
        employee.lastName( employeeRequest.getLastName() );
        employee.password( employeeRequest.getPassword() );
        employee.phoneNumber( employeeRequest.getPhoneNumber() );
        employee.roles( roleRequestListToRoleSet( employeeRequest.getRoles() ) );
        employee.username( employeeRequest.getUsername() );

        return employee.build();
    }

    protected Set<Employee> employeeRequestSetToEmployeeSet(Set<EmployeeRequest> set) {
        if ( set == null ) {
            return null;
        }

        Set<Employee> set1 = new HashSet<Employee>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( EmployeeRequest employeeRequest : set ) {
            set1.add( employeeRequestToEmployee( employeeRequest ) );
        }

        return set1;
    }

    protected Project projectRequestToProject(ProjectRequest projectRequest) {
        if ( projectRequest == null ) {
            return null;
        }

        ProjectBuilder project = Project.builder();

        project.projectDesc( projectRequest.getProjectDesc() );
        project.projectName( projectRequest.getProjectName() );

        return project.build();
    }

    protected Set<Project> projectRequestSetToProjectSet(Set<ProjectRequest> set) {
        if ( set == null ) {
            return null;
        }

        Set<Project> set1 = new HashSet<Project>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ProjectRequest projectRequest : set ) {
            set1.add( projectRequestToProject( projectRequest ) );
        }

        return set1;
    }
}
