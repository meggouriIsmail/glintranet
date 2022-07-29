package com.giantlink.glintranet.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.giantlink.glintranet.entities.Notification;
import com.giantlink.glintranet.requests.NotificationRequest;
import com.giantlink.glintranet.responses.NotificationResponse;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

	NotificationMapper INSTANCE = Mappers.getMapper(NotificationMapper.class);

	Notification toEntity(NotificationRequest commentRequest);

	NotificationResponse toResponse(Notification comment);

	List<NotificationResponse> toResponses(List<Notification> comment);

}
