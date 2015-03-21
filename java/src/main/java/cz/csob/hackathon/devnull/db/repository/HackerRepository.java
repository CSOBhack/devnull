package cz.csob.hackathon.devnull.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.csob.hackathon.devnull.db.entity.Hacker;

public interface HackerRepository extends JpaRepository<Hacker, Long> {

	List<Hacker> findAll();
}