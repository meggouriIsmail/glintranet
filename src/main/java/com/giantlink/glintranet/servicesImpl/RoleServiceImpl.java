package com.giantlink.glintranet.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.persistence.NonUniqueResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giantlink.glintranet.entities.Role;
import com.giantlink.glintranet.mappers.RoleMapper;
import com.giantlink.glintranet.repositories.RoleRepository;
import com.giantlink.glintranet.requests.RoleRequest;
import com.giantlink.glintranet.responses.RoleResponse;
import com.giantlink.glintranet.services.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	RoleMapper roleMapper;
	
	@Override
	public RoleResponse add(RoleRequest request) {
		Optional<Role> oRole = roleRepository.findByName(request.getName());
		if(oRole.isPresent()) 
		{
			throw new NonUniqueResultException(Role.class.getSimpleName()+" already exist");
		}
		
		Role role = Role.builder().name(request.getName()).description(request.getDescription()).build();
		roleRepository.save(role);
		return roleMapper.entityToResoponse(role);
	}

	@Override
	public RoleResponse get(Long id) {
		Optional<Role> oRole = roleRepository.findById(id);
		if(!oRole.isPresent()) 
		{
			throw new NoSuchElementException(Role.class.getSimpleName()+" doesn't exist");
		}
		
		//Role role = oRole.get();
		return roleMapper.entityToResoponse(oRole.get());
	}

	@Override
	public List<RoleResponse> getAll() {
		List<RoleResponse> roleResponses = new ArrayList<RoleResponse>();
		roleRepository.findAll().forEach(r -> { roleResponses.add(roleMapper.entityToResoponse(r));  });
		
		return roleResponses;
	}

	@Override
	public RoleResponse update(Long id, RoleRequest request) {
		Optional<Role> oRole = roleRepository.findById(id);
		if(!oRole.isPresent()) 
		{
			throw new NoSuchElementException(Role.class.getSimpleName()+" already exist");
		}
		
		Role role = oRole.get();
		role.setName(request.getName());
		role.setDescription(request.getDescription());
		
		roleRepository.save(role);
		return roleMapper.entityToResoponse(role);
	}

	@Override
	public void delete(Long id) {
		roleRepository.deleteById(id);
		
	}

}
