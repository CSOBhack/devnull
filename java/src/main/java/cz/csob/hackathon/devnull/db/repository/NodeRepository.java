package cz.csob.hackathon.devnull.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.csob.hackathon.devnull.db.entity.Node;

public interface NodeRepository extends JpaRepository<Node, Long> {

	List<Node> findAll();
}