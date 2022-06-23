package com.giantlink.glintranet.mappers;

import com.giantlink.glintranet.entities.Employee;
import com.giantlink.glintranet.entities.Employee.EmployeeBuilder;
import com.giantlink.glintranet.entities.FAQ;
import com.giantlink.glintranet.requests.EmployeeRequest;
import com.giantlink.glintranet.responses.EmployeeResponse;
import com.giantlink.glintranet.responses.EmployeeResponse.EmployeeResponseBuilder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-23T16:06:06+0100",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.0.v20210708-0430, environment: Java 17 (Eclipse Adoptium)"
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
        employeeResponse.username( employee.getUsername() );

        return employeeResponse.build();
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
}
