package com.giantlink.glintranet.controllers;

import java.util.List;

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

import com.giantlink.glintranet.requests.ProjectRequest;
import com.giantlink.glintranet.responses.ProjectResponse;
import com.giantlink.glintranet.services.ProjectService;

@RestController
@RequestMapping("/api/project")
@CrossOrigin(origins = { "http://localhost:4200" })
public class ProjectController {
	@Autowired
	private ProjectService projectService;

	/*
	 * @GetMapping public ResponseEntity<Map<String, Object>>
	 * getAll(@RequestParam(defaultValue = "0") int page,
	 * 
	 * @RequestParam(defaultValue = "2") int size, @RequestParam(defaultValue = "",
	 * name = "name") String name) { org.springframework.data.domain.Pageable
	 * pageable = PageRequest.of(page, size); return new ResponseEntity<Map<String,
	 * Object>>(projectService.getAllPaginations(name, pageable), HttpStatus.OK);
	 * 
	 * }
	 */
	
	
	@GetMapping
	public ResponseEntity<List<ProjectResponse>> getAll()
	{
		List<ProjectResponse> list = projectService.getAll();
		return new ResponseEntity<List<ProjectResponse>>(list, HttpStatus.OK);
		
	}

	@PostMapping
	public ResponseEntity<ProjectResponse> add(@RequestBody ProjectRequest projectRequest) {
		return new ResponseEntity<ProjectResponse>(projectService.add(projectRequest), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProjectResponse> getOne(@PathVariable Long id) {
		return new ResponseEntity<ProjectResponse>(projectService.get(id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		projectService.delete(id);
		return new ResponseEntity<String>("deleted !", HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProjectResponse> edit(@PathVariable("id") Long id,
			@RequestBody ProjectRequest projectRequest) {
		return new ResponseEntity<ProjectResponse>(projectService.update(id, projectRequest), HttpStatus.OK);
	}

}
