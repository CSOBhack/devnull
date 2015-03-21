/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.csob.hackathon.devnull;

import cz.csob.hackathon.devnull.db.entity.Event;
import cz.csob.hackathon.devnull.db.entity.Hacker;
import cz.csob.hackathon.devnull.db.entity.Node;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.*;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.aspectj.weaver.ast.Test;
import org.json.*;
/**
 *
 * @author tomas
 */
public class InstanceCreator {
    private static JSONArray events;
    private static JSONArray nodes;
    private static JSONArray hackers;
            
    public static void getJson() throws MalformedURLException, IOException {
        String eventUrl = "http://csob-hackathon.herokuapp.com/api/v1/traffic/";
        String nodeUrl = "http://csob-hackathon.herokuapp.com/api/v1/nodes";
        String hackUrl = "http://csob-hackathon.herokuapp.com/api/v1/hackers";
        
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet getRequest = new HttpGet(eventUrl);
        getRequest.addHeader("accept", "application/json");
        HttpResponse response = httpClient.execute(getRequest);
        if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
        }
        BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
        String output = br.readLine();
        events = new JSONObject(output).getJSONObject("_embedded").getJSONArray("events");
        
       // System.out.println(output);
        
        getRequest = new HttpGet(nodeUrl);
        getRequest.addHeader("accept", "application/json");
        response = httpClient.execute(getRequest);
        if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
        }
        br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
        nodes = new JSONObject(br.readLine()).getJSONObject("_embedded").getJSONArray("nodes");
        
        getRequest = new HttpGet(hackUrl);
        getRequest.addHeader("accept", "application/json");
        response = httpClient.execute(getRequest);
        if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
        }
        br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
        hackers = new JSONObject(br.readLine()).getJSONObject("_embedded").getJSONArray("actors");
    }
    
    public static ArrayList<Event> getEventList() {
        ArrayList<Event> arr = new ArrayList();
        
        for (int i = 0; i < events.length(); i++) {
            arr.add(new Event(events.getJSONObject(i)));
        }
        
        return arr;
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
}
