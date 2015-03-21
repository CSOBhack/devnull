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
@Table(name = "hackers")
public class Hacker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "hacker_id", unique = false, nullable = false)
	private int hackerId;

	@Column(name = "name", unique = false, nullable = false)
	private String name;

	@Column(name = "points", unique = false, nullable = false)
	private int points;

	public Hacker() {
	}

	public Hacker(JSONObject js) {
		hackerId = js.getInt("id");
		name = js.getString("name");
		points = js.getInt("current_action_points");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getHackerId() {
		return hackerId;
	}

	public void setHackerId(int hackerId) {
		this.hackerId = hackerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hackerId;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + points;
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
		Hacker other = (Hacker) obj;
		if (hackerId != other.hackerId)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (points != other.points)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Hacker [id=" + id + ", hackerId=" + hackerId + ", name=" + name + ", points=" + points + "]";
	}

}
