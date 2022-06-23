package com.giantlink.glintranet.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import org.mapstruct.factory.Mappers;

import com.giantlink.glintranet.entities.Section;
import com.giantlink.glintranet.requests.SectionRequest;
import com.giantlink.glintranet.responses.SectionResponse;

@Mapper(componentModel = "spring")
public interface SectionMapper 
{
	SectionMapper INSTANCE = Mappers.getMapper(SectionMapper.class);
	
	
	Section requestToEntity(SectionRequest request);
	SectionResponse entityToResponse(Section section);
	
	List<SectionResponse> mapSection(List<Section> sections);
}
