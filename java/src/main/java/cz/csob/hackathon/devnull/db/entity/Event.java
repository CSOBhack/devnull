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
public class Event {
    
    private final int id;
    private final String timestamp;
    private final int actorId;
    private final String action;
    
    public Event(JSONObject js) {
        id = js.getInt("event_id");
        timestamp = js.getString("timestamp");
        actorId = js.getJSONObject("_embedded").getInt("id");
        action = js.getJSONObject("_embedded").getJSONObject("action").getString("name");
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the timestamp
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * @return the actorId
     */
    public int getActorId() {
        return actorId;
    }

    /**
     * @return the action
     */
    public String getAction() {
        return action;
    }
}
