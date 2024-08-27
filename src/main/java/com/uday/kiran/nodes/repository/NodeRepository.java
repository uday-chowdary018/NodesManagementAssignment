package com.uday.kiran.nodes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uday.kiran.nodes.entitys.Node;


@Repository
public interface NodeRepository extends JpaRepository<Node, String>{

}
