/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.csob.hackathon.devnull;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cz.csob.hackathon.devnull.db.entity.Event;
import cz.csob.hackathon.devnull.db.entity.Hacker;
import cz.csob.hackathon.devnull.db.entity.Node;

/**
 *
 * @author tomas
 */
public class RestTest {

	@Test
	public void downloadTest() throws MalformedURLException, IOException {
		InstanceCreator.getJson();
		ArrayList<Event> arr = InstanceCreator.getEventList();
		System.out.println(arr.get(0).getEventId() + " " + arr.get(0).getAction());
		ArrayList<Hacker> arr1 = InstanceCreator.getHackList();
		System.out.println(arr1.get(0).getHackerId() + " " + arr1.get(0).getName());

		List<Node> arr2 = InstanceCreator.getNodeList();
		for (Node n : arr2) {
			System.out.println(n.toString());
		}
	}
}
