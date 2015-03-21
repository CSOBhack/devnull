package cz.csob.hackathon.devnull.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.csob.hackathon.devnull.db.entity.Layer;

public interface LayerRepository extends JpaRepository<Layer, Long> {

	List<Layer> findAll();
}