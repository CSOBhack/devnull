package cz.csob.hackathon.devnull.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.csob.hackathon.devnull.db.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

	List<Admin> findAll();
}