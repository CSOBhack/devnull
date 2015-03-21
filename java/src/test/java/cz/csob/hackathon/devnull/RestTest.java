/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.csob.hackathon.devnull;

import cz.csob.hackathon.devnull.db.entity.Event;
import cz.csob.hackathon.devnull.db.entity.Hacker;
import cz.csob.hackathon.devnull.db.entity.Node;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import org.junit.Test;

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
        ArrayList<Node> arr2 = InstanceCreator.getNodeList();
        System.out.println(arr2.get(0).getNodeId() + " " + arr2.get(0).getIp());
    }
}
