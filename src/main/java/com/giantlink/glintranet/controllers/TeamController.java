package com.giantlink.glintranet.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.giantlink.glintranet.requests.TeamRequest;
import com.giantlink.glintranet.responses.TeamResponse;
import com.giantlink.glintranet.services.TeamService;

@RestController
@RequestMapping("/api/team")
@CrossOrigin(origins = { "http://localhost:4200" })
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	
	@GetMapping
	public ResponseEntity<Map<String, Object>> getAll(@RequestParam(defaultValue = "0") int page,
													  @RequestParam(defaultValue = "2") int size,
													  @RequestParam(defaultValue = "", name = "name") String name) 
	{
		Pageable pageable = PageRequest.of(page, size);
		return new ResponseEntity<Map<String,Object>>(teamService.getAllPaginations(name, pageable), HttpStatus.OK);
		
	}

	@GetMapping("/All")
	public ResponseEntity<List<TeamResponse>> getComments()
	{
		return new ResponseEntity<List<TeamResponse>>(teamService.getAll(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<TeamResponse> add(@RequestBody TeamRequest groupRequest) {
		return new ResponseEntity<TeamResponse>(teamService.add(groupRequest), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TeamResponse> getOne(@PathVariable Long id) {
		return new ResponseEntity<TeamResponse>(teamService.get(id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		teamService.delete(id);
		return new ResponseEntity<String>("deleted !", HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TeamResponse> edit(@PathVariable("id") Long id, @RequestBody TeamRequest groupRequest) {
		return new ResponseEntity<TeamResponse>(teamService.update(id, groupRequest), HttpStatus.OK);
	}
}
