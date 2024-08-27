package com.uday.kiran.nodes.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="nodes")
public class Node {
	@Id
	@Column(name="node_id")
	private String nodeId;
	@Column(name="node_name")
	private String nodeName;
	@Column(name="description")
	private String description;
	@Column(name="memo")
	private String memo;
	@Column(name="node_type")
	private String nodeType;
	@Column(name="parent_node_group_name")
	private String parentNodeGroupName;
	@Column(name="parent_node_group_id")
	private String parentNodeGroupId;
	@Column(name="parent_node_text")
	private String parentNodeText;
	
	public String getNodeId() {
		return nodeId;
	}
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getNodeType() {
		return nodeType;
	}
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}
	public String getParentNodeGroupName() {
		return parentNodeGroupName;
	}
	public void setParentNodeGroupName(String parentNodeGroupName) {
		this.parentNodeGroupName = parentNodeGroupName;
	}
	public String getParentNodeGroupId() {
		return parentNodeGroupId;
	}
	public void setParentNodeGroupId(String parentNodeGroupId) {
		this.parentNodeGroupId = parentNodeGroupId;
	}
	public String getParentNodeText() {
		return parentNodeText;
	}
	public void setParentNodeText(String parentNodeText) {
		this.parentNodeText = parentNodeText;
	}
	@Override
	public String toString() {
		return "Node [nodeId=" + nodeId + ", nodeName=" + nodeName + ", description=" + description + ", memo=" + memo
				+ ", nodeType=" + nodeType + ", parentNodeGroupName=" + parentNodeGroupName + ", parentNodeGroupId="
				+ parentNodeGroupId + ", parentNodeText=" + parentNodeText + "]";
	}
	
	
	

}
