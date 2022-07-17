package com.giantlink.glintranet.mappers;

import com.giantlink.glintranet.entities.Employee;
import com.giantlink.glintranet.entities.Employee.EmployeeBuilder;
import com.giantlink.glintranet.entities.FAQ;
import com.giantlink.glintranet.entities.Role;
import com.giantlink.glintranet.entities.Role.RoleBuilder;
import com.giantlink.glintranet.entities.Team;
import com.giantlink.glintranet.requests.EmployeeRequest;
import com.giantlink.glintranet.requests.RoleRequest;
import com.giantlink.glintranet.responses.EmployeeCommentRes;
import com.giantlink.glintranet.responses.EmployeeCommentRes.EmployeeCommentResBuilder;
import com.giantlink.glintranet.responses.EmployeeResSimplified;
import com.giantlink.glintranet.responses.EmployeeResSimplified.EmployeeResSimplifiedBuilder;
import com.giantlink.glintranet.responses.EmployeeResponse;
import com.giantlink.glintranet.responses.EmployeeResponse.EmployeeResponseBuilder;
import com.giantlink.glintranet.responses.RoleResponse;
import com.giantlink.glintranet.responses.RoleResponse.RoleResponseBuilder;
import com.giantlink.glintranet.responses.TeamResSimplified;
import com.giantlink.glintranet.responses.TeamResSimplified.TeamResSimplifiedBuilder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-17T15:10:21+0100",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429, environment: Java 17.0.2 (Eclipse Adoptium)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public Employee employeeRequestToEmployee(EmployeeRequest employeeRequest) {
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

    @Override
    public EmployeeResponse employeeToEmployeeResponse(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeResponseBuilder employeeResponse = EmployeeResponse.builder();

        employeeResponse.CIN( employee.getCIN() );
        Set<FAQ> set = employee.getFAQs();
        if ( set != null ) {
            employeeResponse.FAQs( new HashSet<FAQ>( set ) );
        }
        employeeResponse.birthDate( employee.getBirthDate() );
        employeeResponse.email( employee.getEmail() );
        employeeResponse.firstName( employee.getFirstName() );
        employeeResponse.id( employee.getId() );
        employeeResponse.lastName( employee.getLastName() );
        employeeResponse.password( employee.getPassword() );
        employeeResponse.phoneNumber( employee.getPhoneNumber() );
        employeeResponse.team( teamToTeamResSimplified( employee.getTeam() ) );
        employeeResponse.username( employee.getUsername() );

        return employeeResponse.build();
    }

    @Override
    public EmployeeCommentRes employeeToEmployeeComment(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeCommentResBuilder employeeCommentRes = EmployeeCommentRes.builder();

        employeeCommentRes.firstName( employee.getFirstName() );
        employeeCommentRes.lastName( employee.getLastName() );

        return employeeCommentRes.build();
    }

    @Override
    public List<EmployeeResponse> mapEmployee(List<Employee> employees) {
        if ( employees == null ) {
            return null;
        }

        List<EmployeeResponse> list = new ArrayList<EmployeeResponse>( employees.size() );
        for ( Employee employee : employees ) {
            list.add( employeeToEmployeeResponse( employee ) );
        }

        return list;
    }

    @Override
    public Set<EmployeeResponse> mapEmployee(Set<Employee> employees) {
        if ( employees == null ) {
            return null;
        }

        Set<EmployeeResponse> set = new HashSet<EmployeeResponse>( Math.max( (int) ( employees.size() / .75f ) + 1, 16 ) );
        for ( Employee employee : employees ) {
            set.add( employeeToEmployeeResponse( employee ) );
        }

        return set;
    }

    @Override
    public Set<Employee> mapEmployeeRequest(Set<EmployeeRequest> employees) {
        if ( employees == null ) {
            return null;
        }

        Set<Employee> set = new HashSet<Employee>( Math.max( (int) ( employees.size() / .75f ) + 1, 16 ) );
        for ( EmployeeRequest employeeRequest : employees ) {
            set.add( employeeRequestToEmployee( employeeRequest ) );
        }

        return set;
    }

    @Override
    public List<EmployeeResSimplified> mapEmployeeSimplified(List<Employee> employees) {
        if ( employees == null ) {
            return null;
        }

        List<EmployeeResSimplified> list = new ArrayList<EmployeeResSimplified>( employees.size() );
        for ( Employee employee : employees ) {
            list.add( toEmployeeSimplified( employee ) );
        }

        return list;
    }

    @Override
    public EmployeeResSimplified toEmployeeSimplified(Employee employees) {
        if ( employees == null ) {
            return null;
        }

        EmployeeResSimplifiedBuilder employeeResSimplified = EmployeeResSimplified.builder();

        employeeResSimplified.CIN( employees.getCIN() );
        employeeResSimplified.birthDate( employees.getBirthDate() );
        employeeResSimplified.email( employees.getEmail() );
        employeeResSimplified.firstName( employees.getFirstName() );
        employeeResSimplified.id( employees.getId() );
        employeeResSimplified.lastName( employees.getLastName() );
        employeeResSimplified.phoneNumber( employees.getPhoneNumber() );
        employeeResSimplified.roles( roleSetToRoleResponseSet( employees.getRoles() ) );
        employeeResSimplified.username( employees.getUsername() );

        return employeeResSimplified.build();
    }

    @Override
    public Set<EmployeeResSimplified> mapEmployeeSimplified(Set<Employee> employees) {
        if ( employees == null ) {
            return null;
        }

        Set<EmployeeResSimplified> set = new HashSet<EmployeeResSimplified>( Math.max( (int) ( employees.size() / .75f ) + 1, 16 ) );
        for ( Employee employee : employees ) {
            set.add( toEmployeeSimplified( employee ) );
        }

        return set;
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

    protected TeamResSimplified teamToTeamResSimplified(Team team) {
        if ( team == null ) {
            return null;
        }

        TeamResSimplifiedBuilder teamResSimplified = TeamResSimplified.builder();

        teamResSimplified.description( team.getDescription() );
        teamResSimplified.id( team.getId() );
        teamResSimplified.name( team.getName() );

        return teamResSimplified.build();
    }

    protected RoleResponse roleToRoleResponse(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleResponseBuilder roleResponse = RoleResponse.builder();

        roleResponse.description( role.getDescription() );
        roleResponse.id( role.getId() );
        roleResponse.name( role.getName() );

        return roleResponse.build();
    }

    protected Set<RoleResponse> roleSetToRoleResponseSet(Set<Role> set) {
        if ( set == null ) {
            return null;
        }

        Set<RoleResponse> set1 = new HashSet<RoleResponse>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Role role : set ) {
            set1.add( roleToRoleResponse( role ) );
        }

        return set1;
    }
}
