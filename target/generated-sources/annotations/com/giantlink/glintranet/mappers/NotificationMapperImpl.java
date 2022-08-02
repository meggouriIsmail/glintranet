package com.giantlink.glintranet.mappers;

import com.giantlink.glintranet.entities.Employee;
import com.giantlink.glintranet.entities.Notification;
import com.giantlink.glintranet.entities.Notification.NotificationBuilder;
import com.giantlink.glintranet.requests.NotificationRequest;
import com.giantlink.glintranet.responses.EmployeeCommentRes;
import com.giantlink.glintranet.responses.EmployeeCommentRes.EmployeeCommentResBuilder;
import com.giantlink.glintranet.responses.NotificationResponse;
import com.giantlink.glintranet.responses.NotificationResponse.NotificationResponseBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-02T20:44:55+0100",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429, environment: Java 17.0.2 (Eclipse Adoptium)"
)
@Component
public class NotificationMapperImpl implements NotificationMapper {

    @Override
    public Notification toEntity(NotificationRequest commentRequest) {
        if ( commentRequest == null ) {
            return null;
        }

        NotificationBuilder notification = Notification.builder();

        notification.content( commentRequest.getContent() );
        notification.isRead( commentRequest.getIsRead() );
        notification.link( commentRequest.getLink() );

        return notification.build();
    }

    @Override
    public NotificationResponse toResponse(Notification comment) {
        if ( comment == null ) {
            return null;
        }

        NotificationResponseBuilder notificationResponse = NotificationResponse.builder();

        notificationResponse.content( comment.getContent() );
        notificationResponse.creationDate( comment.getCreationDate() );
        notificationResponse.employee( employeeToEmployeeCommentRes( comment.getEmployee() ) );
        notificationResponse.id( comment.getId() );
        notificationResponse.isRead( comment.getIsRead() );
        notificationResponse.link( comment.getLink() );

        return notificationResponse.build();
    }

    @Override
    public List<NotificationResponse> toResponses(List<Notification> comment) {
        if ( comment == null ) {
            return null;
        }

        List<NotificationResponse> list = new ArrayList<NotificationResponse>( comment.size() );
        for ( Notification notification : comment ) {
            list.add( toResponse( notification ) );
        }

        return list;
    }

    protected EmployeeCommentRes employeeToEmployeeCommentRes(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeCommentResBuilder employeeCommentRes = EmployeeCommentRes.builder();

        employeeCommentRes.firstName( employee.getFirstName() );
        employeeCommentRes.lastName( employee.getLastName() );
        employeeCommentRes.username( employee.getUsername() );

        return employeeCommentRes.build();
    }
}
