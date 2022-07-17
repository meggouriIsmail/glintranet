package com.giantlink.glintranet.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giantlink.glintranet.requests.RoleRequest;
import com.giantlink.glintranet.responses.RoleResponse;
import com.giantlink.glintranet.services.RoleService;

@RestController
@RequestMapping("/api/role")
@CrossOrigin(origins = { "http://localhost:4200" })
public class RoleController 
{
	@Autowired
	RoleService roleService;
	
	@GetMapping
	public ResponseEntity<List<RoleResponse>> getAllRoles()
	{
		List<RoleResponse> roleResponses = roleService.getAll();
		return new ResponseEntity<List<RoleResponse>>(roleResponses, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RoleResponse> getRole(@PathVariable Long id)
	{
		RoleResponse response = roleService.get(id);
		return new ResponseEntity<RoleResponse>(response, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<RoleResponse> addRole(@RequestBody @Valid RoleRequest request)
	{
		RoleResponse newRole = roleService.add(request);
		return new ResponseEntity<RoleResponse>(newRole, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<RoleResponse> updateRole(@PathVariable Long id, @RequestBody @Valid RoleRequest request)
	{
		RoleResponse updatedRole = roleService.update(id, request);
		return new ResponseEntity<RoleResponse>(updatedRole, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteRole(@PathVariable Long id)
	{
		roleService.delete(id);
		return new ResponseEntity<String>("Deleted",HttpStatus.GONE);
	}
	
}
