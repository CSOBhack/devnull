/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.csob.hackathon.devnull.db.entity;

import org.json.*;

/**
 *
 * @author tomas
 */
public class Hacker {
    private final int id;
    private final String name;
    private final int points;
    
    public Hacker(JSONObject js) {
        id = js.getInt("id");
        name = js.getString("name");
        points = js.getInt("current_action_points");
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the points
     */
    public int getPoints() {
        return points;
    }
}
