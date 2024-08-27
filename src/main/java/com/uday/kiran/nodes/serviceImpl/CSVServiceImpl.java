package com.uday.kiran.nodes.serviceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.uday.kiran.nodes.entitys.Node;
import com.uday.kiran.nodes.repository.NodeRepository;
import com.uday.kiran.nodes.service.CSVService;

@Service
public class CSVServiceImpl implements CSVService {
	@Autowired
	private NodeRepository noderepo;

	@Override
	public List<String> importCSV(MultipartFile file) throws IOException {
		List<String> validationdata	=new ArrayList<>();
		 try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
	            String line;
	           
	            reader.readLine();
	            while ((line = reader.readLine()) != null) {
	                String[] data = line.split(",");
                     if(data.length < 8) {
                    	// lessthen 8 attributes
                    	 continue;
                     }
	                Node node = new Node();
	                node.setNodeId(data[0]);
	                node.setNodeName(data[1]);
	                node.setDescription(data[2]);
	                node.setMemo(data[3]);
	                node.setNodeType(data[4]);
	                node.setParentNodeGroupName(data[5]);
	                node.setParentNodeGroupId(data[6]);
	                node.setParentNodeText(data[7]);
	                String validationError = validateNode(node);
	                if (validationError != null) {
	                	//if validation error save in Arraylist with nodeId
	                	validationdata.add("Node Id :" + node.getNodeId() + " " + validationError);
	                	continue;
	                	
	                }
	                noderepo.save(node);
	            }
	        }catch (IOException e) {
	           
	            throw new IOException("Failed to import CSV" + e.getMessage(), e);
	        }
		 return validationdata;
	}
	
	//validateing the Nodename, nodeid and memo
	private String validateNode(Node node) {
				
		if (node.getNodeName() == null || node.getNodeName().isBlank()) {
		        
			return "Node name cannot be null or blank.";
		        }
		       
		if (!Pattern.matches("^[a-zA-Z0-9 ]*$", node.getNodeName())) {
		           
			return "Node name contains invalid characters.";
		        }
		if (node.getNodeId() == null) {
	        
			return "Node id cannot be null.";
		        }
		       
		       
		if (node.getMemo() == null || node.getMemo().isBlank()) {
		            
			return "Memo cannot be null or blank.";
		        }
				
				return null;
			}


	@Override
	public void saveNode(Node node) {
		 String validationError = validateNode(node);
	        if (validationError != null) {
	            throw new IllegalArgumentException(validationError);
	        }
			noderepo.save(node);
	}
	

	

}
