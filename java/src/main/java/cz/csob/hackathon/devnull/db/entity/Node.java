/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.csob.hackathon.devnull.db.entity;

import java.util.ArrayList;
import org.json.*;

/**
 *
 * @author tomas
 */
public class Node {
    private final int id;
    private final String ip;
    private final String name;
    private final int parentId;
    private int users;
    private ArrayList<Layer> layers;
    
    public Node(JSONObject js) {
        JSONArray arr = js.getJSONObject("_embedded").getJSONArray("layers");
        
        id = js.getInt("id");
        ip = js.getString("ip_address");
        name = js.getString("venue_name");
        parentId = js.getInt("parent_id");
        users = js.getInt("active_users");
        
        for (int i = 0; i < arr.length(); i++) {
            layers.add(new Layer(arr.getJSONObject(i)));
        }
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the parentId
     */
    public int getParentId() {
        return parentId;
    }

    /**
     * @return the users
     */
    public int getUsers() {
        return users;
    }

    /**
     * @return the layers
     */
    public ArrayList<Layer> getLayers() {
        return layers;
    }
}
