/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.csob.hackathon.devnull.db.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.math.NumberUtils;
import org.json.JSONArray;
import org.json.JSONObject;

@Entity
@Table(name = "nodes")
public class Node {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "node_id", unique = true, nullable = false)
	private int nodeId;

	@Column(unique = false, nullable = false)
	private String ip;

	@Column(unique = false, nullable = false)
	private String name;

	@Column(name = "parent_id", unique = false, nullable = false)
	private Integer parentId;

	@Column(name = "users", unique = false, nullable = false)
	private int users;

	@Transient
	private List<Layer> layers = new ArrayList<Layer>();

	public Node() {
	}

	public Node(JSONObject js) {
		JSONArray arr = js.getJSONObject("_embedded").getJSONArray("layers");

		System.out.println(js.toString());

		nodeId = js.getInt("id");
		ip = js.getString("ip_address");
		name = js.getString("venue_name");
		if (js.get("parent_id") == null && NumberUtils.isNumber(js.getString("parent_id"))) {
			parentId = js.getInt("parent_id");
		} else {
			parentId = -1;
		}
		users = js.getInt("active_users");

		for (int i = 0; i < arr.length(); i++) {
			layers.add(new Layer(arr.getJSONObject(i)));
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNodeId() {
		return nodeId;
	}

	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUsers() {
		return users;
	}

	public void setUsers(int users) {
		this.users = users;
	}

	public List<Layer> getLayers() {
		return layers;
	}

	public void setLayers(List<Layer> layers) {
		this.layers = layers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ip == null) ? 0 : ip.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + nodeId;
		result = prime * result + getParentId();
		result = prime * result + users;
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
		Node other = (Node) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ip == null) {
			if (other.ip != null)
				return false;
		} else if (!ip.equals(other.ip))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nodeId != other.nodeId)
			return false;
		if (getParentId() != other.getParentId())
			return false;
		if (users != other.users)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Node [id=" + id + ", nodeId=" + nodeId + ", ip=" + ip + ", name=" + name + ", parentId=" + getParentId() + ", users=" + users + ", layers=" + layers + "]";
	}

	/**
	 * @return the parentId
	 */
	public Integer getParentId() {
		return parentId;
	}

	/**
	 * @param parentId
	 *            the parentId to set
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

}
