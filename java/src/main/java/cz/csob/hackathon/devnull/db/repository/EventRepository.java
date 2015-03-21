package cz.csob.hackathon.devnull.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.csob.hackathon.devnull.db.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

	List<Event> findAll();
}