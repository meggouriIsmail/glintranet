package com.giantlink.glintranet.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.giantlink.glintranet.entities.FeedBackType;
import com.giantlink.glintranet.requests.FeedBackTypeRequest;
import com.giantlink.glintranet.responses.FeedBackTypeResponse;

@Mapper(componentModel = "spring")
public interface FeedBackTypeMapper 
{
	FeedBackTypeMapper INSTANCE = Mappers.getMapper(FeedBackTypeMapper.class);
	
	FeedBackType requestToEntity(FeedBackTypeRequest request);
	FeedBackTypeResponse entityToResponse(FeedBackType feedBackType);
	
	
}
