package cz.csob.hackathon.devnull.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cz.csob.hackathon.devnull.db.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

	List<Event> findAll();

	@Modifying
	@Query(nativeQuery = true, value = "TRUNCATE TABLE events")
	void truncateTable();
}