package com.giantlink.glintranet.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.giantlink.glintranet.entities.FeedBack;
import com.giantlink.glintranet.requests.FeedBackRequest;
import com.giantlink.glintranet.responses.FeedBackResponse;

@Mapper(componentModel = "spring")
public interface FeedBackMapper 
{
	FeedBackMapper INSTANCE = Mappers.getMapper(FeedBackMapper.class);
	
	FeedBack requestToEntity(FeedBackRequest request);	
	FeedBackResponse entityToResponse(FeedBack feedBack);
	
	List<FeedBackResponse> mapFeedBacks(List<FeedBack> feedBacks);
	
}
