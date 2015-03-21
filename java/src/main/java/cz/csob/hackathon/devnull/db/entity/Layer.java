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
public class Layer {
    private final int id;
    private final int robustness;
    private final String name;
    private final int level;
    
    public Layer(JSONObject js) {
        id = js.getInt("id");
        robustness = js.getInt("current_robustness");
        name = js.getString("name");
        level = js.getInt("level");
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Layer other = (Layer) obj;
        if (this.getId() != other.getId()) {
            return false;
        }
        return true;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the robustness
     */
    public int getRobustness() {
        return robustness;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }
    
    
}
