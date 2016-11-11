package com.revature.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TechTrack")
public class TechTrack {

	@Id @SequenceGenerator(name="track_id_seq", sequenceName="track_id_seq") @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="track_id_seq")
	@Column(name = "track_ID")
	private int track_id;

	@Column(name = "track_name")
	private String track_name;

	public TechTrack(String track_name) {
		super();
		this.track_name = track_name;
	}

	public int getTrack_id() {
		return track_id;
	}

	public void setTrack_id(int track_id) {
		this.track_id = track_id;
	}

	public String getTrack_name() {
		return track_name;
	}

	public void setTrack_name(String track_name) {
		this.track_name = track_name;
	}
	
	
	


}
