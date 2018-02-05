package com.markus.workoutprofiles.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userdetails")
public class UserDetailEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Column(name = "user_weight")
	private Double userWeight;

	@Column(name = "user_height")
	private Double userHeight;

	@Column(name = "user_gender")
	private String userGender;

	public Double getUserWeight() {
		return userWeight;
	}

	public void setUserWeight(Double userWeight) {
		this.userWeight = userWeight;
	}

	public Double getUserHeight() {
		return userHeight;
	}

	public void setUserHeight(Double userHeight) {
		this.userHeight = userHeight;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
