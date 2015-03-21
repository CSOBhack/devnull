package cz.csob.hackathon.devnull.db.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import cz.csob.hackathon.devnull.db.entity.TestTable;

public interface TestTableRepository extends Repository<TestTable, Long> {

	List<TestTable> findAll();

}