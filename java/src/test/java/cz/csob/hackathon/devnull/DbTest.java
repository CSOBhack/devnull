package cz.csob.hackathon.devnull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cz.csob.hackathon.devnull.db.entity.TestTable;
import cz.csob.hackathon.devnull.db.repository.TestTableRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Start.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DbTest {

	@BeforeClass
	public static void oneTimeSetUp() {
		Configurer.config();
	}

	@Autowired
	private TestTableRepository repo;

	@Test
	public void objectMapperTest() {
		List<TestTable> list = repo.findAll();
		for (TestTable tbl : list) {
			System.out.println(tbl.toString());
		}
	}
}
