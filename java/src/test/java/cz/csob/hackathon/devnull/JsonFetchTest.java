package cz.csob.hackathon.devnull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cz.csob.hackathon.devnull.db.repository.NodeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Start.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JsonFetchTest {

	@BeforeClass
	public static void oneTimeSetUp() {
		Configurer.config();
	}

	@Autowired
	private NodeRepository nodeRepo;

	@Test
	public void insertTest() throws ClientProtocolException, IOException {
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet getRequest = new HttpGet("http://csob-hackathon.herokuapp.com/api/v1/nodes");
		getRequest.addHeader("accept", "application/json");
		HttpResponse response = httpClient.execute(getRequest);
		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
		}
		BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
		String output = br.readLine();
		System.out.println("============Output:============");
                System.out.println(output);

		// System.out.println(node.toString());
	}
}
