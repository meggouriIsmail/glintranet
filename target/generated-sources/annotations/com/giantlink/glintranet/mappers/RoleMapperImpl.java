package com.giantlink.glintranet.mappers;

import com.giantlink.glintranet.entities.Role;
import com.giantlink.glintranet.entities.Role.RoleBuilder;
import com.giantlink.glintranet.requests.RoleRequest;
import com.giantlink.glintranet.responses.RoleResponse;
import com.giantlink.glintranet.responses.RoleResponse.RoleResponseBuilder;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-16T12:28:51+0100",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.0.v20210708-0430, environment: Java 17 (Eclipse Adoptium)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public Role requestToEntity(RoleRequest request) {
        if ( request == null ) {
            return null;
        }

        RoleBuilder role = Role.builder();

        role.description( request.getDescription() );
        role.name( request.getName() );

        return role.build();
    }

    @Override
    public RoleResponse entityToResoponse(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleResponseBuilder roleResponse = RoleResponse.builder();

        roleResponse.description( role.getDescription() );
        roleResponse.id( role.getId() );
        roleResponse.name( role.getName() );

        return roleResponse.build();
    }
}
