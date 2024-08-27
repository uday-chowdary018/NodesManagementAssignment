package com.uday.kiran.nodes.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.uday.kiran.nodes.entitys.Node;

@Service
public interface CSVService {
	
	public List<String> importCSV(MultipartFile file) throws IOException;

	public void saveNode(Node node);

}
