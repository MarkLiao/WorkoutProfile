package com.markus.workoutprofiles.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "workoutprofile_activity")
@JsonIgnoreProperties(allowGetters = true)
public class WorkoutProfileActivityEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "user_id")
	Long userId;

	@Column(name = "workout_activity")
	private String workoutActivity;

	@Column(name = "workout_activity_type")
	private String workoutActivityType;

	@Column(name = "workout_day_of_the_week")
	private String workoutDayOfTheWeek;

	@Column(name = "calories_burnt")
	private int caloriesBurnt;

	WorkoutProfileActivityEntity(Long userId, String workoutActivity, String workoutActivityType, String dayOfWeek,
			int caloriesBurnt) {
		this.userId = userId;
		this.workoutActivity = workoutActivity;
		this.workoutActivityType = workoutActivityType;
		this.workoutDayOfTheWeek = dayOfWeek;
		this.caloriesBurnt = caloriesBurnt;
	}

	WorkoutProfileActivityEntity() {
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getWorkoutActivity() {
		return workoutActivity;
	}

	public void setWorkoutActivity(String workoutActivity) {
		this.workoutActivity = workoutActivity;
	}

	public String getWorkoutActivityType() {
		return workoutActivityType;
	}

	public void setWorkoutActivityType(String workoutActivityType) {
		this.workoutActivityType = workoutActivityType;
	}

	public String getWorkoutDayOfTheWeek() {
		return workoutDayOfTheWeek;
	}

	public void setWorkoutDayOfTheWeek(String workoutDayOfTheWeek) {
		this.workoutDayOfTheWeek = workoutDayOfTheWeek;
	}

	public int getCaloriesBurnt() {
		return caloriesBurnt;
	}

	public void setCaloriesBurnt(int caloriesBurnt) {
		this.caloriesBurnt = caloriesBurnt;
	}

}
