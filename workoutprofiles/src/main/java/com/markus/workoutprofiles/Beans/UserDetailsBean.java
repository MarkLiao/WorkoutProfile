package com.markus.workoutprofiles.Beans;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDetailsBean {
	private Long userId;
	private Double userHeight;
	private Double userWeight;
	private String userGender;
	private int userAge;
	private String userLastName;
	private String userFirstName;

	public Double getUserHeight() {
		return userHeight;
	}

	public Double getUserWeight() {
		return userWeight;
	}

	public String getUserGender() {
		return userGender;
	}

	public int getUserAge() {
		return userAge;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public Long getUserId() {
		return userId;
	}

	@JsonCreator
	public UserDetailsBean(@JsonProperty("userId") Long userId, @JsonProperty("userFirstName") String userFirstName,
			@JsonProperty("userLastName") String userLastName, @JsonProperty("userAge") int userAge,
			@JsonProperty("height") Double userHeight, @JsonProperty("weight") Double userWeight,
			@JsonProperty("gender") String userGender) {
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userAge = userAge;
		this.userHeight = userHeight;
		this.userGender = userGender;
		this.userWeight = userWeight;
	}

}
