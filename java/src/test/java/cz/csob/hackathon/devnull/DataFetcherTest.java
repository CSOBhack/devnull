package cz.csob.hackathon.devnull;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cz.csob.hackathon.devnull.db.entity.Node;
import cz.csob.hackathon.devnull.db.repository.EventRepository;
import cz.csob.hackathon.devnull.db.repository.HackerRepository;
import cz.csob.hackathon.devnull.db.repository.LayerRepository;
import cz.csob.hackathon.devnull.db.repository.NodeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Start.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DataFetcherTest {

	@BeforeClass
	public static void oneTimeSetUp() {
		Configurer.config();
	}

	@Autowired
	private NodeRepository nodeRepo;

	@Autowired
	private EventRepository eventRepo;

	@Autowired
	private LayerRepository layerRepo;

	@Autowired
	private HackerRepository hackerRepo;

	@Test
	public void fillAll() throws MalformedURLException, IOException {
		// eventRepo.truncateTable();

		InstanceCreator.getJson();
		nodeRepo.deleteAllInBatch();
		List<Node> nodes = InstanceCreator.getNodeList();
		nodeRepo.save(nodes);

		layerRepo.deleteAllInBatch();
		for (Node node : nodes) {
			layerRepo.save(node.getLayers());
		}

		hackerRepo.deleteAllInBatch();
		hackerRepo.save(InstanceCreator.getHackList());

		eventRepo.deleteAllInBatch();
		// eventRepo.truncateTable();
		eventRepo.save(InstanceCreator.getEventList());
	}

}
