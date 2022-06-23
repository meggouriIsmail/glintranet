package com.giantlink.glintranet.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.persistence.NonUniqueResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giantlink.glintranet.entities.Tag;
import com.giantlink.glintranet.mappers.TagMapper;
import com.giantlink.glintranet.repositories.TagRepository;
import com.giantlink.glintranet.requests.TagRequest;
import com.giantlink.glintranet.responses.TagResponse;
import com.giantlink.glintranet.services.TagService;

@Service
public class TagServiceImpl implements TagService
{
	@Autowired
	TagRepository tagRepository;
	
	@Autowired
	TagMapper tagMapper;

	@Override
	public TagResponse add(TagRequest request) 
	{
		Optional<Tag> foundTag = tagRepository.findByName(request.getName());
		if(foundTag.isPresent()) 
		{	throw new NonUniqueResultException(Tag.class.getSimpleName()+" already exisit");	}
		
		Tag newTag = null;
		newTag = Tag.builder().name(request.getName())
							  .description(request.getDescription())
							  .build();
		tagRepository.save(newTag);
		return tagMapper.entityToResponse(newTag);
		
	}

	@Override
	public TagResponse get(Long id) {
		Optional<Tag> foundTag = tagRepository.findById(id);
		if(!foundTag.isPresent())
		{	throw new NoSuchElementException("Tag doesnt exist");	}
		
		TagResponse tag = tagMapper.entityToResponse(tagRepository.getById(id));
		return tag;
	}

	@Override
	public List<TagResponse> getAll() {
		List<TagResponse> tagResponses = new ArrayList<TagResponse>();
		tagRepository.findAll().forEach(tg -> tagResponses.add(tagMapper.entityToResponse(tg)));
		return tagResponses;
	}

	@Override
	public TagResponse update(Long id, TagRequest request) {
		Optional<Tag> foundTag = tagRepository.findById(id);
		if(foundTag.isEmpty()) 
		{	throw new NoSuchElementException("Tag donest exist");	}
		
		Tag tag = tagRepository.getById(id);
		tag.setName(request.getName());
		tag.setDescription(request.getDescription());
		tagRepository.save(tag);
		
		
		return tagMapper.entityToResponse(tag);
	}

	@Override
	public void delete(Long id) {
		tagRepository.deleteById(id);
		
	}

}
