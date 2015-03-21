/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.csob.hackathon.devnull.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.JSONObject;

@Entity
@Table(name = "layers")
public class Layer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "layer_id", unique = true, nullable = false)
	private int layerId;

	@Column(unique = false, nullable = false)
	private int robustness;

	@Column(unique = false, nullable = false)
	private String name;

	@Column(unique = false, nullable = false)
	private int level;

	public Layer() {
	}

	public Layer(JSONObject js) {
		layerId = js.getInt("id");
		robustness = js.getInt("current_robustness");
		name = js.getString("name");
		level = js.getInt("level");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getLayerId() {
		return layerId;
	}

	public void setLayerId(int layerId) {
		this.layerId = layerId;
	}

	public int getRobustness() {
		return robustness;
	}

	public void setRobustness(int robustness) {
		this.robustness = robustness;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + layerId;
		result = prime * result + level;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + robustness;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Layer other = (Layer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (layerId != other.layerId)
			return false;
		if (level != other.level)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (robustness != other.robustness)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Layer [id=" + id + ", layerId=" + layerId + ", robustness=" + robustness + ", name=" + name + ", level=" + level + "]";
	}

}
