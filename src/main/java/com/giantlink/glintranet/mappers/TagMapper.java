package com.giantlink.glintranet.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.giantlink.glintranet.entities.Tag;
import com.giantlink.glintranet.requests.TagRequest;
import com.giantlink.glintranet.responses.TagResponse;

@Mapper(componentModel = "spring")
public interface TagMapper 
{
	TagMapper INSTANCE = Mappers.getMapper(TagMapper.class);
	
	Tag requestToEntity(TagRequest tagRequest);
	TagResponse entityToResponse(Tag tag);
	
	//List<TagResponse> mapTags(List<Tag> tags);
}
