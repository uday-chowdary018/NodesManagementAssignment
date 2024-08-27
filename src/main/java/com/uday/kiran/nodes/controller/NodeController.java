package com.uday.kiran.nodes.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.uday.kiran.nodes.entitys.Node;
import com.uday.kiran.nodes.repository.NodeRepository;
import com.uday.kiran.nodes.service.CSVService;

@RestController
@RequestMapping("/api/nodes")
public class NodeController {
	
	@Autowired
	private NodeRepository noderepo;
	
	@Autowired
	private CSVService service;
	
	@PostMapping("/uploadcsv")
	public ResponseEntity<Object> uploadCSV(@RequestParam("file") MultipartFile file) {
		try {
		List<String> validationdata =	service.importCSV(file);
			if(!validationdata.isEmpty()) {
				 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationdata);
			}
		
		return  ResponseEntity.ok("CSV file imported successfully");
		}catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error:" + e.getMessage());
        } 
		
		
	}
	//create the node
	@PostMapping
	public ResponseEntity<String> createNode(@RequestBody Node node) {

	    try {
	        service.saveNode(node);
	        return ResponseEntity.ok("Node created successfully.");
	    } catch (IllegalArgumentException e) {
	        return ResponseEntity.badRequest().body(e.getMessage());
	    }
	}

	
   //get all nodes
	@GetMapping
	public List<Node> getAllNodes(){
		return noderepo.findAll();
		
	}
	
	
	
	
	
	

}
