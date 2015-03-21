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

		System.out.println("EVENTS");
		System.out.println("----------------");
		ArrayList<Event> arr = InstanceCreator.getEventList();
		for (Event e : arr) {
			System.out.println("EVENT = " + e.toString());
		}
		System.out.println("----------------");

		System.out.println("HACKERS");
		ArrayList<Hacker> arr1 = InstanceCreator.getHackList();
		System.out.println(arr1.get(0).getHackerId() + " " + arr1.get(0).getName());

		System.out.println("NODES");
		List<Node> arr2 = InstanceCreator.getNodeList();
		for (Node n : arr2) {
			System.out.println(n.toString());
		}
	}
}
