package com.revature.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tech_track")
public class TechTrack {

	@Id 
	@SequenceGenerator(name="track_id_seq", sequenceName="track_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="track_id_seq")
	@Column(name = "track_id")
	private int trackId;

	@Column(name = "track_name")
	private String trackName;

	public TechTrack() {}
	
	public TechTrack(String trackName) {
		this.trackName = trackName;
	}

	public int getTrackId() {
		return trackId;
	}

	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}

	public String getTrackName() {
		return trackName;
	}

	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}

	@Override
	public String toString() {
		return "TechTrack [trackId=" + trackId + ", trackName=" + trackName + "]";
	}

}
