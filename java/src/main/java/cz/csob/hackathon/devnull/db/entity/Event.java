/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.csob.hackathon.devnull.db.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.json.JSONObject;

import cz.csob.hackathon.devnull.util.DateUtil;

@Entity
@Table(name = "events")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "event_id", unique = false, nullable = false)
	private int eventId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "happened_at", nullable = true)
	private Date happenedAt;

	@Column(name = "actor_id", unique = false, nullable = false)
	private int actorId;

	@Column(name = "node_id", unique = false, nullable = false)
	private int nodeId;

	@Column(unique = false, nullable = false)
	private String action;

	public Event() {
	}

	public Event(JSONObject js) {
		eventId = js.getInt("event_id");
		String dateStr = js.getString("happened_at");
		happenedAt = DateUtil.parseTimezoneDateTime(dateStr);
		actorId = js.getJSONObject("_embedded").getJSONObject("actor").getInt("id");
		nodeId = js.getJSONObject("_embedded").getJSONObject("action").getInt("id");
		action = js.getJSONObject("_embedded").getJSONObject("action").getString("name");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public Date getHappenedAt() {
		return happenedAt;
	}

	public void setHappenedAt(Date happenedAt) {
		this.happenedAt = happenedAt;
	}

	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public int getNodeId() {
		return nodeId;
	}

	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((action == null) ? 0 : action.hashCode());
		result = prime * result + actorId;
		result = prime * result + eventId;
		result = prime * result + ((happenedAt == null) ? 0 : happenedAt.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + nodeId;
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
		Event other = (Event) obj;
		if (action == null) {
			if (other.action != null)
				return false;
		} else if (!action.equals(other.action))
			return false;
		if (actorId != other.actorId)
			return false;
		if (eventId != other.eventId)
			return false;
		if (happenedAt == null) {
			if (other.happenedAt != null)
				return false;
		} else if (!happenedAt.equals(other.happenedAt))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nodeId != other.nodeId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", eventId=" + eventId + ", happenedAt=" + happenedAt + ", actorId=" + actorId + ", nodeId=" + nodeId + ", action=" + action + "]";
	}

}
