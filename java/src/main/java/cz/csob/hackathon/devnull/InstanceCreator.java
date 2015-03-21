/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.csob.hackathon.devnull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.csob.hackathon.devnull.db.entity.Admin;
import cz.csob.hackathon.devnull.db.entity.Event;
import cz.csob.hackathon.devnull.db.entity.Hacker;
import cz.csob.hackathon.devnull.db.entity.Node;

/**
 *
 * @author tomas
 */
public class InstanceCreator {
	private static JSONArray nodes;
	private static JSONArray hackers;
	private static JSONArray admins;
	private static List<Event> eventObjs = new ArrayList<Event>();

	public static void getJson() throws MalformedURLException, IOException {
		// String eventUrl = "http://csob-hackathon.herokuapp.com/api/v1/traffic/";
		String nodeUrl = "http://csob-hackathon.herokuapp.com/api/v1/nodes";
		String hackUrl = "http://csob-hackathon.herokuapp.com/api/v1/hackers";
		String adminsUrl = "http://csob-hackathon.herokuapp.com/api/v1/admins";

		HttpClient httpClient = HttpClientBuilder.create().build();
		// HttpGet getRequest = new HttpGet(eventUrl);
		// getRequest.addHeader("accept", "application/json");
		// HttpResponse response = httpClient.execute(getRequest);
		// if (response.getStatusLine().getStatusCode() != 200) {
		// throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
		// }
		// BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
		// String output = br.readLine();
		// events = new JSONObject(output).getJSONObject("_embedded").getJSONArray("events");

		// System.out.println(output);

		HttpGet getRequest = new HttpGet(nodeUrl);
		getRequest.addHeader("accept", "application/json");
		HttpResponse response = httpClient.execute(getRequest);
		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
		}
		BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
		nodes = new JSONObject(br.readLine()).getJSONObject("_embedded").getJSONArray("nodes");
		for (Node n : getNodeList()) {
			int id = n.getNodeId();
			parseOneNodeEvents(id);
		}

		getRequest = new HttpGet(hackUrl);
		getRequest.addHeader("accept", "application/json");
		response = httpClient.execute(getRequest);
		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
		}
		br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
		hackers = new JSONObject(br.readLine()).getJSONObject("_embedded").getJSONArray("actors");

		getRequest = new HttpGet(adminsUrl);
		getRequest.addHeader("accept", "application/json");
		response = httpClient.execute(getRequest);
		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
		}
		br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
		admins = new JSONObject(br.readLine()).getJSONObject("_embedded").getJSONArray("actors");
	}

	private static void parseOneNodeEvents(int id) throws JSONException, IOException {
		HttpClient httpClient = HttpClientBuilder.create().build();
		String url = "http://csob-hackathon.herokuapp.com/api/v1/nodes/" + id;
		HttpGet getRequest = new HttpGet(url);
		getRequest.addHeader("accept", "application/json");
		HttpResponse response = httpClient.execute(getRequest);
		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
		}
		BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
		JSONArray events = new JSONObject(br.readLine()).getJSONObject("_embedded").getJSONArray("events");
		for (int i = 0; i < events.length(); i++) {
			eventObjs.add(new Event(events.getJSONObject(i)));
		}
	}

	public static List<Event> getEventList() {
		return eventObjs;
	}

	public static ArrayList<Node> getNodeList() {
		ArrayList<Node> arr = new ArrayList();

		for (int i = 0; i < nodes.length(); i++) {
			arr.add(new Node(nodes.getJSONObject(i)));
		}

		return arr;
	}

	public static ArrayList<Hacker> getHackList() {
		ArrayList<Hacker> arr = new ArrayList();

		for (int i = 0; i < hackers.length(); i++) {
			arr.add(new Hacker(hackers.getJSONObject(i)));
		}

		return arr;
	}

	public static ArrayList<Admin> getAdminsList() {
		ArrayList<Admin> arr = new ArrayList();

		for (int i = 0; i < admins.length(); i++) {
			arr.add(new Admin(admins.getJSONObject(i)));
		}

		return arr;
	}
}
