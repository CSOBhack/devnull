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

import cz.csob.hackathon.devnull.db.entity.Node;
import cz.csob.hackathon.devnull.db.repository.NodeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Start.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DbTest {

	@BeforeClass
	public static void oneTimeSetUp() {
		Configurer.config();
	}

	@Autowired
	private NodeRepository nodeRepo;

	@Test
	public void selectTest() {
		List<Node> list = nodeRepo.findAll();
		for (Node oneNode : list) {
			System.out.println(oneNode.toString());
		}
	}

	@Test
	public void saveTest() {
		Node node = new Node();
		node.setIp("127.0.0.1");
		node.setName("Jméno nody");
		node.setNodeId(1);
		node.setParentId(2);
		node.setUsers(17);

		nodeRepo.save(node);
		System.out.println("Saved with ID = " + node.getId());
	}
}
